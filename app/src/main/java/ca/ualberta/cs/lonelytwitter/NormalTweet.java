package ca.ualberta.cs.lonelytwitter;

/**
 * Created by jinzhu on 9/15/16.
 */
public class NormalTweet extends Tweet implements Tweetable { //do not have multiple inherit

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

}
