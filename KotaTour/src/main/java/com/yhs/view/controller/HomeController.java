package com.yhs.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    // index.html 실행 시
    @GetMapping(value = "/index")
    public String home(){
        
        return "index"; // index.jsp 실행
    }
}