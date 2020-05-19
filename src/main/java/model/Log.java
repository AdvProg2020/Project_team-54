package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Log {
    private int logId;
    private Date logDate;

    public Log(){
        this.logDate = new Date();
    }

    public Date getLogDate() {
        return logDate;
    }



}
