package dev.terry.app;

import dev.terry.data.ComplaintDAOPostgres;
import dev.terry.data.MeetingDAOPostgres;
import dev.terry.handlers.complaints.CreateComplaintHandler;
import dev.terry.services.ComplaintService;
import dev.terry.services.ComplaintServiceImpl;
import dev.terry.services.MeetingService;
import dev.terry.services.MeetingServiceImpl;
import io.javalin.Javalin;

public class App {
    public final static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());
    public final static MeetingService meetingService = new MeetingServiceImpl(new MeetingDAOPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        //Complaint Handlers
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();

        app.post("/complaints", createComplaintHandler); //Creates a new complaint

        //Meeting Handlers

        app.get("/meetings", null);

        //AppUser Handlers


        app.start();
    }
}
