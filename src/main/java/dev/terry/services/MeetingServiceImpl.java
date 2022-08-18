package dev.terry.services;

import dev.terry.data.ComplaintDAO;
import dev.terry.data.MeetingDAO;
import dev.terry.entities.Meeting;

import java.util.List;

public class MeetingServiceImpl implements MeetingService{
    private MeetingDAO meetingDAO;
    public MeetingServiceImpl(MeetingDAO meetingDAO){
        this.meetingDAO = meetingDAO;
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return this.meetingDAO.getAllMeetings();
    }
}
