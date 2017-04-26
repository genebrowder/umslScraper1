package edu.umsl.advancedwebdesign.dao;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by genebrowder on 4/25/17.
 */
public class TwitterDao {



    /**
     * Created by genebrowder on 4/25/17.
     */
    String searchString="";


    public void twitterQueryForString() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            Query query = new Query(searchString);
            query.setLang("english");
            query.setCount(100);

            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("USER:@" + status.getUser().getScreenName() + " , TEXT:" + status.getText()+ " , CREATED:" + status.getCreatedAt());
            }

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

    public void twitterQueryUserTimeline() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {

            List statuses = twitter.getUserTimeline("stephimargeth");

            for(int i=0; i<statuses.size(); i++){
                Status status = (Status) statuses.get(i);

                System.out.println("USER:@" + status.getUser().getScreenName() + " , TEXT:" + status.getText()+ " , CREATED:" + status.getCreatedAt());
            }

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }


}
