package edu.umsl.advancedwebdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.umsl.advancedwebdesign.dao.TwitterDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by genebrowder on 5/12/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login", "/", "index"}, method = RequestMethod.GET)
    public ModelAndView login() {

        return new ModelAndView("login");

    }

    @RequestMapping(value = {"/login", "/", "index"}, method = RequestMethod.POST)
    public ModelAndView loginSubmit(HttpSession session, HttpServletRequest request) {

        String submitType = request.getParameter("action");
        System.out.println("SubmitType = " + submitType);

        ModelAndView mav = null;

        if (submitType.equals("Search_Facebook")) {
            mav = new ModelAndView("searchFacebook");

        } else if (submitType.equals("Search_Linkedin")) {
            mav = new ModelAndView("searchFacebook");

        } else if (submitType.equals("Search_Instagram")) {
            mav = new ModelAndView("searchFacebook");

        }else if (submitType.equals("Search_Twitter")) {
            TwitterDao ta = new TwitterDao();
            String searchString = request.getParameter("searchTwitterString");
            ta.setSearchString(searchString);
            ta.twitterQueryForString();
            //ta.twitterQueryUserTimeline();
            mav = new ModelAndView("searchFacebook");

        } else if (submitType.equals("Search_Google+")) {
            mav = new ModelAndView("searchFacebook");

        }

        return mav;
    }


}

