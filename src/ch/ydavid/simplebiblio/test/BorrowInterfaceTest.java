package ch.ydavid.simplebiblio.test;

import ch.ydavid.simplebiblio.backend.BorrowManagement;
import ch.ydavid.simplebiblio.sqlHandler.SqlHandler;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BorrowInterfaceTest {

    private static SqlHandler sqlHandler = new SqlHandler();
    private BorrowManagement borrowManager = new BorrowManagement();

    @BeforeAll
    public static void init() throws SQLException {

        String query = "insert tbl_items values (-99, 'testbook', 0, 'roboter', -99, -99, 1)";

        sqlHandler.getConnection().createStatement().execute(query);

    }

    @AfterAll
    public static void tearDown() throws SQLException {

        String query = "delete from tbl_borrowed where fk_idUser = -99";

        sqlHandler.getConnection().createStatement().execute(query);

        query = "delete from tbl_items where idMedia = -99";

        sqlHandler.getConnection().createStatement().execute(query);


    }

    @Test
    @Order(1)
    void borrowItem() throws SQLException {

        borrowManager.borrowItem(-99, -99);


        String query = "SELECT count(*) as 'count' from tbl_borrowed where fk_idUser = -99 and returned = 0";
        ResultSet rs = sqlHandler.getConnection().createStatement().executeQuery(query);

        assert rs.next();

        assertEquals(1, rs.getInt("count"));


    }

    @Test
    @Order(2)
    void returnItem() throws SQLException {

        borrowManager.returnItem(-99);

        String query = "SELECT count(*) as 'count' from tbl_borrowed where fk_idUser = -99 and returned = 1";
        ResultSet rs = sqlHandler.getConnection().createStatement().executeQuery(query);

        assert rs.next();

        assertEquals(1, rs.getInt("count"));

    }
}