package controller;

import model.Comment;
import model.CommentStatus;
import model.Good;
import java.security.PublicKey;
import java.util.ArrayList;

public class ProductManager extends Manager{
    private Good product;

    public ProductManager(Good product) {
        super();
        this.product = product;
    }

    public void postComment(Comment comment) {
        comment.setCommentStatus(CommentStatus.confirmed);
        this.product.addComment(comment);
    }

    public void rejectComment(Comment comment) {
        comment.setCommentStatus(CommentStatus.disApprovedByManager);
    }

    public ArrayList<String> compare(String productId1, String productId2) {
        //TODO
        ArrayList<String> sample = new ArrayList<String>();
        return sample;
    }
}
