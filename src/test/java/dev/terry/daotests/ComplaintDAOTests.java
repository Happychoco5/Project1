package dev.terry.daotests;

import dev.terry.data.ComplaintDAO;
import dev.terry.data.ComplaintDAOPostgres;
import dev.terry.entities.Complaint;
import dev.terry.utils.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComplaintDAOTests {

    static ComplaintDAO complaintDAO = new ComplaintDAOPostgres();
//    @BeforeAll() //This method will execute before any tests
//    static void setup(){
//        try(Connection conn = ConnectionUtil.createConnection()){
//            String sql = "create table complaint(\n" +
//                    "\tid serial primary key,\n" +
//                    "\tsubject varchar(50) not null,\n" +
//                    "\tdescription varchar(200) not null,\n" +
//                    "\t-- category varchar(20) not null,\n" +
//                    "\tmeetingId int references meeting(id) default -1,\n" +
//                    "\tpriority varchar(20) not null default 'UNASSIGNED'\n" +
//                    ");";
//            Statement statement = conn.createStatement();
//            statement.execute(sql);
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }

    @Test
    @Order(1)
    void create_complaint()
    {
        Complaint complaint = new Complaint("Burgers", "Too many burgers in my house :(");
        Complaint savedComplaint = this.complaintDAO.createComplaint(complaint);
        Assertions.assertEquals(complaint.getId(), savedComplaint.getId());

    }

    @Test
    @Order(2)
    void get_all_complaints(){
        Assertions.assertNotEquals(0, this.complaintDAO.getAllComplaints());
    }



//    @AfterAll
//    static void teardown(){
//        try(Connection conn = ConnectionUtil.createConnection()){
//            String sql = "drop table complaint";
//            Statement statement = conn.createStatement();
//            statement.execute(sql);
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
}
