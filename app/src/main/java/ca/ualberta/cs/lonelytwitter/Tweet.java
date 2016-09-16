package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by jinzhu on 9/15/16.
 */
public abstract class Tweet {
    //attributes
    private String message; //private: only this class can change this virables
    private Date date;
    //public String s; //public: others can change it
    //protected String p; //protected: can only be used inherit
    //String nothing;

    //each tweet has a list of moods
    private ArrayList<ABC> MoodList;

    public Tweet(String message){ //constructor:set the same name as the class
        this.message= message; //key word this:the message in this class
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 140){
            throw new TweetTooLongException();
            //Do something!
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

}
