package edu.umsl.advancedwebdesign.controller;

import edu.umsl.advancedwebdesign.dao.TwitterDao;
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
public class DashboardController {

    @RequestMapping(value = {"/dashboard", "/", "index"}, method = RequestMethod.GET)
    public ModelAndView dashboad() {
        //when website first starts this is a get
        return new ModelAndView("dashboard");

    }

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.POST)
    public ModelAndView dashboardSubmit(HttpSession session, HttpServletRequest request) {

        String submitType = request.getParameter("action");
        System.out.println("SubmitType = " + submitType);

        ModelAndView mav = null;

        if (submitType.equals("Facebook")) {
            mav = new ModelAndView("searchFacebook");

        } else if (submitType.equals("Twitter")) {
            mav = new ModelAndView("searchTwitter");

        }
        return mav;
    }


}

