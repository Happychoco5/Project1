package dev.terry.daotests;

import dev.terry.data.MeetingDAO;
import dev.terry.data.MeetingDAOPostgres;
import dev.terry.entities.Meeting;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeetingDAOTests {

    static MeetingDAO meetingDAO = new MeetingDAOPostgres();
    @Test
    @Order(1)
    void get_all_meetings(){
        Assertions.assertEquals(1, meetingDAO.getAllMeetings().size());
    }
}
