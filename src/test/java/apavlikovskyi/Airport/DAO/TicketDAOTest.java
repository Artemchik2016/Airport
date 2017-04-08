package apavlikovskyi.Airport.DAO;

import apavlikovskyi.airport.dao.TicketDAO;
import apavlikovskyi.airport.dao.daoUtil.DataBaseConnection;
import apavlikovskyi.airport.entity.TicketEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Diana P on 06.04.2017.
 */
public class TicketDAOTest {
    private TicketDAO ticketDAO;


    @Before
    public void before(){
        DataBaseConnection.testMigrate();
        ticketDAO= new TicketDAO();
        ticketDAO.save(new TicketEntity(1,"TK3071",
                "business","3047",
                "B23"));
        ticketDAO.save(new TicketEntity(2,"TK3072",
                "business","3047",
                "B23"));
        ticketDAO.save(new TicketEntity(3,"TK3073",
                "business","3047",
                "B23"));

    }

    @After
    public void after() throws SQLException {
        PreparedStatement ps= DataBaseConnection.getConnection().prepareStatement("DROP DATABASE testAirport");
        ps.executeUpdate();
        ps.close();
        DataBaseConnection.closeConnection();
    }


    @Test
    public void delete() throws Exception {
        ticketDAO.deleteById(1);
        TicketEntity ticketEntity=ticketDAO.getById(1);
        assertNull(ticketEntity);
    }

    @Test
    public void getAll() throws Exception {
        List<TicketEntity> list= ticketDAO.getAll();
        assertNotNull(list);
    }

    @Test
    public void getById() throws Exception {
     TicketEntity ticketEntity=ticketDAO.getById(2);
     assertEquals("TK3072",ticketEntity.getVoyageId());
    }

    @Test
    public void update() throws Exception {
       TicketEntity ticketEntity=new TicketEntity(1,"TK4082","econom","B232","A23");
        ticketDAO.update(ticketEntity);
        assertEquals(ticketDAO.getById(1),ticketEntity);

    }

    @Test
    public void save() throws Exception {

       TicketEntity ticketEntity=ticketDAO.getById(3);
       assertEquals("B23",ticketEntity.getSeatNumber());
       assertEquals("3047",ticketEntity.getPassengerId());
    }
}