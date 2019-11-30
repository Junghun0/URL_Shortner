package com.junghoon.spring.urlshortner.service;

import com.junghoon.spring.urlshortner.mapper.ShortnerMapper;
import com.junghoon.spring.urlshortner.model.UrlData;
import com.oracle.tools.packager.Log;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private static final String baseUrl = "http://localhost:8080/";
    private static final int URL_Length = 7;

    @Autowired
    ShortnerMapper shortnerMapper;

    public boolean isValidUrl(String url) {
        if (url.contains("www.")){
            url = url.replace("www.","");
        }
        return url.endsWith(".com") || url.endsWith(".co.kr");
    }

    public String removeFront(String url) {
        return url.replace("www.","");
    }

    public String encodeURL(String url, int lastIndex) {
        StringBuilder stringBuilder = new StringBuilder();


        byte[] encoded1 = Base64.encodeBase64(String.valueOf(lastIndex).getBytes());
        String indexEncode = new String(encoded1).replace("=","");
        String removedEnd = removeEnd(url);
        if (removedEnd.contains("http://")) {
            removedEnd = removedEnd.replace("http://","");
        }

        byte[] encoded = Base64.encodeBase64(removedEnd.getBytes());
        String resultUrl = new String(encoded).replaceAll("=","");

        stringBuilder.append(indexEncode);
        stringBuilder.append(resultUrl.substring(0, URL_Length - indexEncode.length()));

        return baseUrl+stringBuilder.toString();
    }

    private String removeEnd(String url) {
        if (url.contains(".com")) {
            return url.replace(".com",""); }
        else{
            return url.replace(".co.kr", "");
        }
    }

    public int existData(String url) {
        return shortnerMapper.existUrl(url);
    }

    public void insertData(UrlData urlData) {
        shortnerMapper.insertData(urlData);
    }

    public String getBaseUrl(String shortenUrl){
        return shortnerMapper.getBaseUrl(shortenUrl);
    }

    public String getShortenUrl(String originUrl) {
        return shortnerMapper.getShortenUrl(originUrl);
    }

    public Integer getMaxIndex() {
        return shortnerMapper.getMaxIndex();
    }

    public int isEmptyTable() {
        return shortnerMapper.isEmptyTable();
    }
}
