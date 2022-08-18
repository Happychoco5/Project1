package dev.terry.data;

import dev.terry.entities.Complaint;
import dev.terry.entities.enums.Priority;
import dev.terry.entities.enums.Status;
import dev.terry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOPostgres implements ComplaintDAO{
    @Override
    public Complaint createComplaint(Complaint complaint) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into complaint values(default, ?, ?, default, default)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, complaint.getSubject());
            preparedStatement.setString(2, complaint.getDescription());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedId = rs.getInt("id");
            int generatedMeetingId = rs.getInt("meetingId");
            String generatedPriority = rs.getString("priority");

            complaint.setId(generatedId);
            complaint.setMeetingId(generatedMeetingId);
            complaint.setPriority(Priority.valueOf(generatedPriority));

            return complaint;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Complaint> getAllComplaints() {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from complaint";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            ResultSet rs = preparedStatement.executeQuery();

            List<Complaint> complaints = new ArrayList<>();
            while(rs.next()){
                Complaint complaint = new Complaint();

                complaint.setId(rs.getInt("id"));
                complaint.setSubject(rs.getString("subject"));
                complaint.setDescription(rs.getString("description"));
                complaint.setMeetingId(rs.getInt("meetingId"));
                complaint.setPriority(Priority.valueOf(rs.getString("priority")));

                complaints.add(complaint);
            }
            return complaints;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
