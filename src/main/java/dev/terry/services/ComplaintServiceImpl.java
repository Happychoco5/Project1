package dev.terry.services;

import dev.terry.data.ComplaintDAO;
import dev.terry.entities.Complaint;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService{
    private ComplaintDAO complaintDAO;
    public ComplaintServiceImpl(ComplaintDAO complaintDAO){
        this.complaintDAO = complaintDAO;
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        if(complaint.getSubject() == ""){
            //can't be blank
            throw new RuntimeException("Cannot have subject be empty");
        }
        return this.complaintDAO.createComplaint(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return this.complaintDAO.getAllComplaints();
    }
}
