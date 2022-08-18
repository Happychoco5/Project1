package dev.terry.data;

import dev.terry.entities.Meeting;

import java.util.List;

public interface MeetingDAO {
    public List<Meeting> getAllMeetings();
}
