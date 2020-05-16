package com.music.cloundmusic;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//全局异常
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception e) {
        e.printStackTrace();
        Map<String,Object> map = new HashMap<>();
        map.put("errorMsg",e.toString());
        return map;
    }
}
