package dev.terry.data;

import dev.terry.entities.Complaint;

import java.util.List;

public interface ComplaintDAO {
    public Complaint createComplaint(Complaint complaint);

    public List<Complaint> getAllComplaints();
}
