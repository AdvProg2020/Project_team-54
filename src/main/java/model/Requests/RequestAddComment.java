package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Buyer;
import model.Comment;
import model.CommentStatus;
import model.Good;

import java.util.ArrayList;

public class RequestAddComment extends Request {
    private String comment;
    private Buyer buyer;
    private Good good;
    private static ArrayList<RequestAddComment> allAddCommentRequests = new ArrayList<>();

    public RequestAddComment(String comment, Buyer buyer, Good good) {
        super();
        this.comment = comment;
        this.buyer = buyer;
        this.good = good;
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
        Comment newComment = new Comment(buyer,good,comment);
        newComment.setCommentStatus(CommentStatus.confirmed);
        good.getComments().add(newComment);
        Comment.allComments.add(newComment);
    }

    @Override
    public String toString() {
        return "RequestAddComment With Id: " + this.getId() + "\n" +
                "Requested From: " + buyer.getUsername() + "\n" +
                "With Comment: " + comment;
    }
}
