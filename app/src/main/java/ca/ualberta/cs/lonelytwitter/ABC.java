package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jinzhu on 9/15/16.
 */
public abstract class ABC { //represents the current mood

    private Date date;

    public ABC(Date date) {
        this.date = date;
    }
    public ABC() {
        this.date = new Date();
    }

    public abstract String ReturnMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
