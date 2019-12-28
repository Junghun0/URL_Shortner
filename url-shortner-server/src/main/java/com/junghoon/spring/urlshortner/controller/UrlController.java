package com.junghoon.spring.urlshortner.controller;

import com.junghoon.spring.urlshortner.model.ResponseUrl;
import com.junghoon.spring.urlshortner.model.UrlData;
import com.junghoon.spring.urlshortner.service.UrlService;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UrlController {

    private UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("url/{requestUrl}")
    public ResponseEntity<ResponseUrl> shortenUrl(@PathVariable("requestUrl") String requestUrl ) {
        ResponseUrl responseUrl = new ResponseUrl();
        System.out.println("call-> "+requestUrl);
        if (urlService.isValidUrl(requestUrl)){ // 유효한 주소 받을 때
            Integer index = 0;

            if (requestUrl.contains("www.")) {
                requestUrl = urlService.removeFront(requestUrl);
            }

            if (urlService.isEmptyTable() == 0) {
                index = 0;
            } else {
                index = urlService.getMaxIndex();
            }
            String shortenUrl = urlService.encodeURL(requestUrl,(index+1));

            if (urlService.getShortenUrl(requestUrl) == null) {//처음 요청하는 주소
                urlService.insertData(new UrlData(0,requestUrl, shortenUrl));
                responseUrl.setResultUrl(shortenUrl);
            } else {//원래 요청했던 주소
                responseUrl.setResultUrl(urlService.getShortenUrl(requestUrl));
            }
            return new ResponseEntity<>(responseUrl, HttpStatus.OK);
        }

        // 유효하지 않은 주소 받을 때
        return new ResponseEntity<>(responseUrl, HttpStatus.OK);
    }

}
