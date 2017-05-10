package edu.umsl.advancedwebdesign.controller;

import edu.umsl.advancedwebdesign.dao.RedditDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by genebrowder on 5/12/16.
 */
@Controller
public class RedditController {

    @RequestMapping(value = {"/searchReddit"}, method = RequestMethod.GET)
    public ModelAndView redditSearch() {
        //when website first starts this is a get
        return new ModelAndView("dashboard");

    }

    @RequestMapping(value = {"/searchReddit"}, method = RequestMethod.POST)
    public ModelAndView redditSearchSubmit(HttpSession session, HttpServletRequest request) {

        String searchType = request.getParameter("action");
        System.out.println("searchType = " + searchType);

        ModelAndView mav = null;

        String[] filename = new String[1];
        filename[0]="";
        try {


            if (searchType.equals("Search_By_String")) {
                RedditDao ta = new RedditDao();
                String searchString = request.getParameter("searchByString");
                ta.setSearchString(searchString);



                if(ta.redditQueryByString(filename))
                {
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }


            } else if (searchType.equals("Search_By_HashTag")) {

                RedditDao ta = new RedditDao();
                String searchString = request.getParameter("searchByHashTag");
                ta.setSearchString(searchString);


                if (ta.redditQueryByHashTag(filename)) {
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                } else {
                    mav = new ModelAndView("failure");
                }



            }
            else if (searchType.equals("Search_By_RedditHandle")) {
                RedditDao ta = new RedditDao();
                String searchString = request.getParameter("searchByRedditHandle");
                ta.setSearchString(searchString);


                if(ta.redditQueryByredditHandle(filename)){
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }


            } else if (searchType.equals("Search_By_Trending")) {
                RedditDao ta = new RedditDao();


                if(ta.redditQueryByTrends(filename)){
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }

            }
        }catch(Exception e){
            mav = new ModelAndView("dashboard");
        }

        return mav;
    }


}

