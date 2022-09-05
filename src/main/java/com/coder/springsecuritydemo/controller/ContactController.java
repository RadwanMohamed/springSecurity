package com.coder.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("myContact")
    public String saveNotice(String input){
        return  "test in notice";
    }
}
