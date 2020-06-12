package model;


import java.util.ArrayList;

public class Comment {
    private Account account;
    private Good good;
    private String title;
    private String comment;
    private CommentStatus commentStatus;
    private boolean isBought;
    private ArrayList<Comment> allComments;
    {
        allComments = new ArrayList<>();

    }


    public Comment(Account account, Good good, String comment){
        this.account = account;
        this.good = good;
        this.comment = comment;
        this.commentStatus = CommentStatus.processing;
        allComments.add(this);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }
}