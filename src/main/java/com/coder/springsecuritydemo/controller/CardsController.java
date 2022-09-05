package com.coder.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("myCards")
    public String myCards(String input){
        return  "test in myCards";
    }
}
