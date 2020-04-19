import java.util.ArrayList;
import java.util.Date;

public class Off {
    private int id;
    private OffStatus status;
    public ArrayList<Good> offsList;
    public Date startTime;
    public Date endTime;
    public int amountOfOff;

    public Off(int id, Date startTime, Date endTime, int amountOfOff) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amountOfOff = amountOfOff;
    }

    //public int getId() { return id; }

    public void showProductId(int productId){}


}
