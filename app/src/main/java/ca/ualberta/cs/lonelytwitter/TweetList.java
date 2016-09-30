package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Aries on 9/29/16.
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList() {

    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet) {
        if(hasTweet(tweet)) {
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount(Tweet tweet) {
        return tweets.size();
    }
}
