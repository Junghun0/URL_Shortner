package com.junghoon.spring.urlshortner.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UrlData {
    private int idx;
    private String originUrl;
    private String shortenUrl;
}
