package dev.terry.services;

import dev.terry.entities.Complaint;

import java.util.List;

public interface ComplaintService {

    public Complaint createComplaint(Complaint complaint);

    public List<Complaint> getAllComplaints();
}
