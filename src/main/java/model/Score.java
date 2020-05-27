package main.java.model;
public class Score {
    private Buyer buyer;
    private int score;
    private Good good;

    public Score(Buyer buyer, Good good, int score){
        this.buyer = buyer;
        this.good = good;
        this.score = score;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}