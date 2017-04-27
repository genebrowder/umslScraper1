package edu.umsl.advancedwebdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by genebrowder on 5/12/16.
 */
@Controller
public class FailureController {

    @RequestMapping(value = {"/failure"}, method = RequestMethod.GET)
    public ModelAndView failure() {

        return new ModelAndView("failure");

    }

    @RequestMapping(value = {"/failure"}, method = RequestMethod.POST)
    public ModelAndView failureSubmit(HttpSession session, Model model,HttpServletRequest request) {

        String submitType = request.getParameter("action");
        System.out.println("SubmitType = " + submitType);

        model.asMap().clear();
        session.invalidate();

        return new ModelAndView("dashboard");

    }
}
