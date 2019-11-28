package com.junghoon.spring.urlshortner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UrlController {

    @GetMapping("/url/{requestUrl}")
    public String testMethod2(@PathVariable("requestUrl") String requestUrl) {
        System.out.println("request com-> " + requestUrl);
        return "success";
    }

}
