package com.music.cloundmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Controller
public class ErrorController {

    @RequestMapping("/errorPage")
    public String errorPage(Map<String,Object> map,HttpServletRequest request){

        String errorMsg = (String) request.getSession().getAttribute("errorMsg");
        String errorURL = (String) request.getSession().getAttribute("errorURL");
        request.getSession().setAttribute("errorMsg",null);
        request.getSession().setAttribute("errorURL",null);
        if(errorMsg==null) {
            errorMsg = "";
            errorURL = "";
        }
        map.put("errorMsg",errorMsg);
        map.put("errorURL",errorURL);
        return "errorPage";
    }
}
