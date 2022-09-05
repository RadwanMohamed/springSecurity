package com.coder.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("myNotice")
    public String saveNotice(String input){
        return  "test in notice";
    }
}
