package dev.terry.services;

import dev.terry.data.ComplaintDAO;
import dev.terry.entities.Complaint;
import dev.terry.entities.enums.Priority;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService{
    private ComplaintDAO complaintDAO;
    public ComplaintServiceImpl(ComplaintDAO complaintDAO){
        this.complaintDAO = complaintDAO;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        if(complaint.getSubject() == "" || complaint.getDescription() == ""){
            //can't be blank
            throw new RuntimeException("Cannot have field be empty");
        }
        return this.complaintDAO.createComplaint(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return this.complaintDAO.getAllComplaints();
    }

    @Override
    public Complaint getComplaintWithId(int id) {
        return this.complaintDAO.getComplaintWithId(id);
    }

    @Override
    public Complaint updateMeeting(Complaint complaint, int meetingId) {
        return this.complaintDAO.updateMeeting(complaint, meetingId);
    }

    @Override
    public Complaint updatePriority(Complaint complaint, Priority priority) {
        return this.complaintDAO.updatePriority(complaint, priority);
    }
}
