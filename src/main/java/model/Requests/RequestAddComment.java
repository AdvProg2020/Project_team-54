package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Comment;

import java.util.ArrayList;

public class RequestAddComment extends Request {
    private Comment comment;
    private static ArrayList<RequestAddComment> allAddCommentRequests = new ArrayList<>();

    public RequestAddComment(Comment comment) {
        super();
        this.comment = comment;
        allAddCommentRequests.add(this);
//        getAllRequests().add(this);
        // vaqti request sakhte mishe, be AllRequests ham ezafe mishe
    }

    @Override
    public void denyRequest() {
        status = RequestConfirmation.Denied;
        Request.getAllRequests().remove(this);
        AlertBox.display("Request denied");
    }

    @Override
    public void acceptRequest(int id) {
        //nemidoonm chie
    }
}
