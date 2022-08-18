package dev.terry.data;

import dev.terry.entities.Meeting;
import dev.terry.entities.enums.Status;
import dev.terry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOPostgres implements MeetingDAO{
    @Override
    public List<Meeting> getAllMeetings() {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from meeting";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            List<Meeting> meetings = new ArrayList<>();
            while(rs.next()){
                Meeting meeting = new Meeting();

                meeting.setId(rs.getInt("id"));
                meeting.setAddress(rs.getString("summary"));
                meeting.setAddress(rs.getString("address"));
                meeting.setStatus(Status.valueOf(rs.getString("status")));
                meeting.setTime(rs.getLong("time"));

                meetings.add(meeting);
            }
            return meetings;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
