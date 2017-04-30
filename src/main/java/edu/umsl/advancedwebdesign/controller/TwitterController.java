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
public class TwitterController {

    @RequestMapping(value = {"/searchTwitter"}, method = RequestMethod.GET)
    public ModelAndView twitterSearch() {
        //when website first starts this is a get
        return new ModelAndView("dashboard");

    }

    @RequestMapping(value = {"/searchTwitter"}, method = RequestMethod.POST)
    public ModelAndView twitterSearchSubmit(HttpSession session, HttpServletRequest request) {

        String searchType = request.getParameter("action");
        System.out.println("searchType = " + searchType);

        ModelAndView mav = null;

        String[] filename = new String[1];
        filename[0]="";
        try {


            if (searchType.equals("Search_By_String")) {
                TwitterDao ta = new TwitterDao();
                String searchString = request.getParameter("searchByString");
                ta.setSearchString(searchString);



                if(ta.twitterQueryByString(filename))
                {
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }


            } else if (searchType.equals("Search_By_HashTag")) {

                TwitterDao ta = new TwitterDao();
                String searchString = request.getParameter("searchByHashTag");
                ta.setSearchString(searchString);


                if (ta.twitterQueryByHashTag(filename)) {
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                } else {
                    mav = new ModelAndView("failure");
                }



            }
            else if (searchType.equals("Search_By_TwitterHandle")) {
                TwitterDao ta = new TwitterDao();
                String searchString = request.getParameter("searchByTwitterHandle");
                ta.setSearchString(searchString);


                if(ta.twitterQueryByTwitterHandle(filename)){
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }


            } else if (searchType.equals("Search_By_DataStream")) {
                TwitterDao ta = new TwitterDao();


                if(ta.twitterQueryByDataStream()){
                    System.out.println("Filename ="+filename[0]);
                    mav = new ModelAndView("success");
                    mav.addObject("fileName", filename[0]);
                }else{
                    mav = new ModelAndView("failure");
                }

            } else if (searchType.equals("Search_By_Trending")) {
                TwitterDao ta = new TwitterDao();


                if(ta.twitterQueryByTrends(filename)){
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

