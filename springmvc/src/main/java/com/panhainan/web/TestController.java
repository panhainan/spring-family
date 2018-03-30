package com.panhainan.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test(){
        log.debug("test method");
        return "test";
    }
    @RequestMapping("/index")
    public String index(){
        log.debug("index method");
        return "index";
    }
    @RequestMapping("/test/hello")
    public String hello(){
        log.debug("hello method");
        return "test";
    }
}
