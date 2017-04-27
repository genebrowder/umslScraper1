package edu.umsl.advancedwebdesign.dao;

import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesSampleEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.BasicClient;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by genebrowder on 4/25/17.
 */
public class TwitterDao {


    /**
     * Created by genebrowder on 4/25/17.
     */
    String searchString = "";


    public Boolean twitterQueryByString() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");

        if (!searchString.isEmpty()) {


            try {

                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();

                Query query = new Query(searchString);
                query.setLang("english");
                query.setCount(100);

                QueryResult result = twitter.search(query);
                if (result.hasNext()) {
                    for (Status status : result.getTweets()) {
                        System.out.println("USER:@" + status.getUser().getScreenName() + " , TEXT:" + status.getText() + " , CREATED:" + status.getCreatedAt() + " , LOCATION:" + status.getGeoLocation());
                    }
                } else {
                    System.out.println("ERROR!!!!");
                    return false;
                }

                return true;

            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to search tweets: " + te.getMessage());
                return false;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
                return false;

            }

        } else {
            return false;
        }
    }

    public Boolean twitterQueryByHashTag() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");


        try {

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            Query query = new Query("#" + searchString);
            query.setLang("english");
            query.setCount(100);

            QueryResult result = twitter.search(query);
            if (result.hasNext()) {
                for (Status status : result.getTweets()) {
                    System.out.println("USER:@" + status.getUser().getScreenName() + " , TEXT:" + status.getText() + " , CREATED:" + status.getCreatedAt() + " , LOCATION:" + status.getGeoLocation());
                }
            } else {
                System.out.println("ERROR!!!!");
                return false;
            }

            return true;
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

            return false;

        }
    }

    public Boolean twitterQueryByTwitterHandle() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");


        try {

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            List statuses = twitter.getUserTimeline(searchString);
            if (statuses.size() > 0) {
                for (int i = 0; i < statuses.size(); i++) {
                    Status status = (Status) statuses.get(i);
                    System.out.println("USER:@" + status.getUser().getScreenName() + " , TEXT:" + status.getText() + " , CREATED:" + status.getCreatedAt() + " , LOCATION:" + status.getGeoLocation());
                }
            } else {
                System.out.println("ERROR!!!!");
                return false;
            }

            return true;

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

            return false;


        }
    }

    public Boolean twitterQueryByTrends() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");

        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            ResponseList<Location> locations;
            locations = twitter.getAvailableTrends();
            if (locations.size() > 0) {
                System.out.println("Showing available trends");
                for (Location location : locations) {
                    System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
                }
                System.out.println("done.");
            } else {
                System.out.println("ERROR!!!!");
                return false;
            }

            return true;

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

            return false;


        }
    }

//    public void twitterQueryByLocation() {
//
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
//        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
//        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
//        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
//                "");
//
//
//
//        try {
//
//            TwitterFactory tf = new TwitterFactory(cb.build());
//            Twitter twitter = tf.getInstance();
//
//            Place place = twitter.getGeoDetails("St.Louis, MO");
//            System.out.println("name: " + place.getName());
//            System.out.println("country: " + place.getCountry());
//            System.out.println("country code: " + place.getCountryCode());
//            System.out.println("full name: " + place.getFullName());
//            System.out.println("id: " + place.getId());
//            System.out.println("place type: " + place.getPlaceType());
//            System.out.println("street address: " + place.getStreetAddress());
//            Place[] containedWithinArray = place.getContainedWithIn();
//            if (containedWithinArray != null && containedWithinArray.length != 0) {
//                System.out.println("  contained within:");
//                for (Place containedWithinPlace : containedWithinArray) {
//                    System.out.println("  id: " + containedWithinPlace.getId() + " name: " + containedWithinPlace.getFullName());
//                }
//            }
//
//
//
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.out.println("Failed to search tweets: " + te.getMessage());
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error: " + e.getMessage());
//
//        }
//    }


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Boolean twitterQueryByDataStream() throws InterruptedException {
        try {
            // Create an appropriately sized blocking queue

            BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10000);

            // Define our endpoint: By default, delimited=length is set (we need this for our processor)
            // and stall warnings are on.
            StatusesSampleEndpoint endpoint = new StatusesSampleEndpoint();
            endpoint.stallWarnings(false);

            String consumerKey = "qqgZF7wU3G75gfVbngbTw7Xnz";
            String consumerSecret = "8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs";
            String token = "16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ";
            String secret = "htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw";

            Authentication auth = new OAuth1(consumerKey, consumerSecret, token, secret);
            //Authentication auth = new com.twitter.hbc.httpclient.auth.BasicAuth(username, password);

            // Create a new BasicClient. By default gzip is enabled.
            BasicClient client = new ClientBuilder()
                    .name("sampleExampleClient")
                    .hosts(Constants.STREAM_HOST)
                    .endpoint(endpoint)
                    .authentication(auth)
                    .processor(new StringDelimitedProcessor(queue))
                    .build();

            // Establish a connection
            client.connect();

            // Do whatever needs to be done with messages
            for (int msgRead = 0; msgRead < 1000; msgRead++) {
                if (client.isDone()) {
                    System.out.println("Client connection closed unexpectedly: " + client.getExitEvent().getMessage());
                    return false;
                }

                String msg = queue.poll(5, TimeUnit.SECONDS);
                if (msg == null) {
                    System.out.println("Did not receive a message in 5 seconds");
                } else {
                    System.out.println(msg);
                }
            }

            client.stop();

            // Print some stats
            System.out.printf("The client read %d messages!\n", client.getStatsTracker().getNumMessages());

            return true;

        } catch (InterruptedException ie) {
            ie.printStackTrace();
            System.out.println("Failed to search tweets: " + ie.getMessage());

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

            return false;


        }

    }

}

