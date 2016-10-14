package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception {
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(), getActivity()); //runs the app with extra info, bring the acticity
    }

    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class); //if not in lonelytwitter acctivity, throw out error and fail
        solo.clickOnButton("Clear"); //clean up everything every test

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");

        solo.clickOnButton("Save"); //text on the button "not" the id!!!
        solo.clearEditText((EditText)solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");

        assertFalse(solo.waitForText("Test Tweet!"));

    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity(); //check if the tweet been put in the list

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class); //if not in lonelytwitter activity, throw out error and fail
        solo.clickOnButton("Clear"); //clean up everything every test

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet");


        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0); // get first tweet from list
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0); //click on the first one

        solo.assertCurrentActivity("Wrong Activity!", EditTweetActivity.class); //can go back and forth in activities

        assertTrue((solo.waitForText("Test Tweet")));

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class); //should go back to lonely twitter activity

    }

    //@BeforeClass //run once every time -- check the usage after class

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}