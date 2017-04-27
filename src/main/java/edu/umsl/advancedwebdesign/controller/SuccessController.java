package edu.umsl.advancedwebdesign.controller;

import edu.umsl.advancedwebdesign.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by genebrowder on 5/12/16.
 */
@Controller
public class SuccessController {

    @RequestMapping(value = {"/success"}, method = RequestMethod.GET)
    public ModelAndView success() {

        return new ModelAndView("dashboard");

    }
    @RequestMapping(value = {"/success"}, method = RequestMethod.POST)
    public ModelAndView successSubmit(HttpSession session, Model model) {


        model.asMap().clear();
        session.invalidate();

        return new ModelAndView("dashboard");

    }
}
