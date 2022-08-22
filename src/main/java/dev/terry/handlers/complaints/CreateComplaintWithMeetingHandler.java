package dev.terry.handlers.complaints;

import com.google.gson.Gson;
import dev.terry.app.App;
import dev.terry.entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintWithMeetingHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int meetingId = Integer.parseInt(ctx.pathParam("mId"));
        String json = ctx.body();
        Gson gson = new Gson();

        Complaint complaint = gson.fromJson(json, Complaint.class);

        Complaint savedComplaint = App.complaintService.createComplaintWithMeetingId(complaint, meetingId);

        String complaintJson = gson.toJson(savedComplaint);

        ctx.result(complaintJson);
    }
}
