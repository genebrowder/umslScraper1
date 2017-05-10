package edu.umsl.advancedwebdesign.dao;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by genebrowder on 4/25/17.
 */
public class RedditDao {


    /**
     * Created by genebrowder on 4/25/17.
     */
    String searchString = "";


    public Boolean redditQueryByString(String[] filename) {

//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
//        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
//        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
//        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
//                "");


//        cb.setOAuthConsumerKey("zrDOyxH1fJbpGJQ5HoBJtRb09");
//        cb.setOAuthConsumerSecret("kYpjDvDHsYfaHOHu5kwjt8XDgnN8pmLOyLzR231JgsLEDBLVI0");
//        cb.setOAuthAccessToken("857887738921701377-2PuuQv4BUBAXw5ybFkE4cXKh1rnm32k");
//        cb.setOAuthAccessTokenSecret("VXMWksMcEexHl9GdL1UuudLuN7wkwdm5guG3aqXyYVWMe" +
//                "");


        if (!searchString.isEmpty()) {


            return true;

        } else {
            return false;
        }
    }

    public Boolean redditQueryByHashTag(String[] filename) {

//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
//        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
//        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
//        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
//                "");


//        cb.setOAuthConsumerKey("zrDOyxH1fJbpGJQ5HoBJtRb09");
//        cb.setOAuthConsumerSecret("kYpjDvDHsYfaHOHu5kwjt8XDgnN8pmLOyLzR231JgsLEDBLVI0");
//        cb.setOAuthAccessToken("857887738921701377-2PuuQv4BUBAXw5ybFkE4cXKh1rnm32k");
//        cb.setOAuthAccessTokenSecret("VXMWksMcEexHl9GdL1UuudLuN7wkwdm5guG3aqXyYVWMe" +
//                "");


        if (!searchString.isEmpty()) {


           return true;

        } else {
            return false;
        }
    }


    public Boolean redditQueryByredditHandle(String[] filename) {

//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
//        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
//        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
//        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
//                "");


        if (!searchString.isEmpty()) {


            return true;

        } else {
            return false;
        }
    }

    public Boolean redditQueryByTrends(String[] filename) {
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true);
//        cb.setOAuthConsumerKey("qqgZF7wU3G75gfVbngbTw7Xnz");
//        cb.setOAuthConsumerSecret("8ZxBqLVYAv7O8qVdtm3j3V5MyguiRNBrJR19P0smGqRdSYcMMs");
//        cb.setOAuthAccessToken("16372575-LlMZrcBd3sE2CezunLLyHnBbODclZi30RGclPC8ZJ");
//        cb.setOAuthAccessTokenSecret("htsrOxtWR4w8EMBapRBPL0qbAXmkeb9RVWyEfGfLDXuhw" +
//                "");

        return true;
    }


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }




//    public String writeToFile(String method,QueryResult result) {
//
//        String filename="";
//
//        BufferedWriter bw = null;
//        FileWriter fw = null;
//
//        try {
//
//            SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
//            Date now = new Date();
//            String strDate = sdfDate.format(now);
//
//            filename = method+strDate+".csv";
//
//            fw = new FileWriter(filename);
//            bw = new BufferedWriter(fw);
//
//            String column_headers = "reddit_message_id,creation date,user,text";
//
//            bw.write(column_headers);
//
//            bw.newLine();
//
//            for (Status status : result.getTweets()) {
//
//                String text = status.getText();
//                text = text.replace("\n", "").replace("\r", "");
//                String content = status.getId() + "," + status.getCreatedAt() + "," + "@" + status.getUser().getScreenName() + "," + text;
//
//
//                bw.write(content);
//                bw.newLine();
//            }
//
//            System.out.println("Done");
//
//
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        } finally {
//
//            try {
//
//                if (bw != null)
//                    bw.close();
//
//                if (fw != null)
//                    fw.close();
//
//            } catch (IOException ex) {
//
//                ex.printStackTrace();
//
//            }
//
//        }
//
//         return filename;
//
//    }

//    public String writeToFile(String method,List statuses) {
//
//        String filename="";
//
//        BufferedWriter bw = null;
//        FileWriter fw = null;
//
//        try {
//
//            SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
//            Date now = new Date();
//            String strDate = sdfDate.format(now);
//
//            filename = method+strDate+".csv";
//
//            fw = new FileWriter(filename);
//            bw = new BufferedWriter(fw);
//
//            String column_headers = "reddit_message_id,creation date,user,text";
//            bw.write(column_headers);
//            bw.newLine();
//
//            for (int i = 0; i < statuses.size(); i++) {
//                Status status = (Status) statuses.get(i);
//                String text = status.getText();
//                text = text.replace("\n", "").replace("\r", "");
//                String content = status.getId() + "," + status.getCreatedAt() + "," + "@" + status.getUser().getScreenName() + "," + text;
//
//
//                bw.write(content);
//                bw.newLine();
//            }
//
//            System.out.println("Done");
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        } finally {
//
//            try {
//
//                if (bw != null)
//                    bw.close();
//
//                if (fw != null)
//                    fw.close();
//
//            } catch (IOException ex) {
//
//                ex.printStackTrace();
//
//            }
//
//        }
//
//        return filename;
//
//    }



}

