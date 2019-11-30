package com.junghoon.spring.urlshortner.controller;

import com.junghoon.spring.urlshortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RedirectController {

    private UrlService urlService;

    @Autowired
    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("{shorturl}")
    public String redirect(@PathVariable("shorturl") String shorturl) {
        String baseUrl = urlService.getBaseUrl("http://localhost:8080/"+shorturl);
        return "redirect:http://" + baseUrl;
    }
}
