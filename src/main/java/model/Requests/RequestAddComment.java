package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Comment;

public class RequestAddComment extends Request {
    private Comment comment;

    public RequestAddComment(Comment comment) {
        this.comment = comment;
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
