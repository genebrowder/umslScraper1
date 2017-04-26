package edu.umsl.advancedwebdesign.controller;

import edu.umsl.advancedwebdesign.dao.UserLoginInfoDao;
import edu.umsl.advancedwebdesign.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by genebrowder on 5/12/16.
 */
@Controller
public class RegistrationController {
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registration() {

        return new ModelAndView("registration");

    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView registrationSubmit(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserName(userName);
        userLoginInfo.setPassword(password);
        userLoginInfo.setFirstName(firstName);
        userLoginInfo.setLastName(lastName);

        UserLoginInfoDao.saveUserLoginInfo(userLoginInfo);

        return new ModelAndView("login");

    }

}
