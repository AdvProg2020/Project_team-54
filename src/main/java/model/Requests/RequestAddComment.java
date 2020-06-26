package model.Requests;

import model.Comment;

public class RequestAddComment extends Request {
    private Comment comment;

    public RequestAddComment(Comment comment) {
        this.comment = comment;
    }
}
