package edu.umsl.advancedwebdesign.dao;


import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


    public Boolean twitterQueryByString(String[] filename) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");


//        cb.setOAuthConsumerKey("zrDOyxH1fJbpGJQ5HoBJtRb09");
//        cb.setOAuthConsumerSecret("kYpjDvDHsYfaHOHu5kwjt8XDgnN8pmLOyLzR231JgsLEDBLVI0");
//        cb.setOAuthAccessToken("857887738921701377-2PuuQv4BUBAXw5ybFkE4cXKh1rnm32k");
//        cb.setOAuthAccessTokenSecret("VXMWksMcEexHl9GdL1UuudLuN7wkwdm5guG3aqXyYVWMe" +
//                "");


        if (!searchString.isEmpty()) {


            try {

                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();

                Query query = new Query(searchString);
                query.setLang("en");
                query.setCount(100);


                QueryResult result = twitter.search(query);
                if (result.getTweets().size()>0) {
                    filename[0] = writeToFile("twitterQueryByString",result);
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

    public Boolean twitterQueryByHashTag(String[] filename) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
                "");


//        cb.setOAuthConsumerKey("zrDOyxH1fJbpGJQ5HoBJtRb09");
//        cb.setOAuthConsumerSecret("kYpjDvDHsYfaHOHu5kwjt8XDgnN8pmLOyLzR231JgsLEDBLVI0");
//        cb.setOAuthAccessToken("857887738921701377-2PuuQv4BUBAXw5ybFkE4cXKh1rnm32k");
//        cb.setOAuthAccessTokenSecret("VXMWksMcEexHl9GdL1UuudLuN7wkwdm5guG3aqXyYVWMe" +
//                "");


        if (!searchString.isEmpty()) {


            try {

                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();

                Query query = new Query("#"+searchString);
                query.setLang("en");
                query.setCount(100);


                QueryResult result = twitter.search(query);
                if (result.getTweets().size()>0) {
                    filename[0] = writeToFile("twitterQueryByHashTag",result);
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


    public Boolean twitterQueryByTwitterHandle(String[] filename) {

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

                List statuses = twitter.getUserTimeline(searchString);

                if (statuses.size() > 0) {
                    filename[0] = writeToFile("twitterQueryByTwitterHandle",statuses);
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

    public Boolean twitterQueryByTrends(String[] filename) {
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
            ArrayList<Trends> trends = new ArrayList<Trends>();

            locations = twitter.getAvailableTrends();
            if (locations.size() > 0) {
                int count=0;
                for (Location location : locations) {
                    Trends trend = twitter.getPlaceTrends(location.getWoeid());
                    trends.add(trend);
                    count = count+trend.getTrends().length;

                    if(count>100){
                        break;
                    }
                }
                filename[0] = writeToFile("twitterQueryByTrends",trends);
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


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }



    public String writeToFile(String method,ArrayList<Trends> trends) {

        String filename="";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
            Date now = new Date();
            String strDate = sdfDate.format(now);

            filename = method+strDate+".csv";

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);

            String column_headers = "name, query, URL";

            bw.write(column_headers);

            bw.newLine();

            for (Trends trend : trends) {

                for (int i = 0; i < trend.getTrends().length; i++) {

                    String text = trend.getTrends()[i].getQuery();
                    text = text.replace("%23", "@").replace("\r", "");

                    String content = trend.getTrends()[i].getName() + "," + text + "," + trend.getTrends()[i].getURL()  ;

                    bw.write(content);
                    bw.newLine();
                }
            }

            System.out.println("Done");



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return filename;

    }

    public String writeToFile(String method,QueryResult result) {

        String filename="";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
            Date now = new Date();
            String strDate = sdfDate.format(now);

            filename = method+strDate+".csv";

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);

            String column_headers = "twitter_message_id,creation date,user,text";

            bw.write(column_headers);

            bw.newLine();

            for (Status status : result.getTweets()) {

                String text = status.getText();
                text = text.replace("\n", "").replace("\r", "");
                String content = status.getId() + "," + status.getCreatedAt() + "," + "@" + status.getUser().getScreenName() + "," + text;


                bw.write(content);
                bw.newLine();
            }

            System.out.println("Done");



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

         return filename;

    }

    public String writeToFile(String method,List statuses) {

        String filename="";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
            Date now = new Date();
            String strDate = sdfDate.format(now);

            filename = method+strDate+".csv";

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);

            String column_headers = "twitter_message_id,creation date,user,text";
            bw.write(column_headers);
            bw.newLine();

            for (int i = 0; i < statuses.size(); i++) {
                Status status = (Status) statuses.get(i);
                String text = status.getText();
                text = text.replace("\n", "").replace("\r", "");
                String content = status.getId() + "," + status.getCreatedAt() + "," + "@" + status.getUser().getScreenName() + "," + text;


                bw.write(content);
                bw.newLine();
            }

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return filename;

    }



}

