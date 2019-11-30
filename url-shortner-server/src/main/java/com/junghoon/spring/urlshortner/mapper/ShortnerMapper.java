package com.junghoon.spring.urlshortner.mapper;

import com.junghoon.spring.urlshortner.model.UrlData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShortnerMapper {

    void insertData(UrlData urlData);

    int existUrl(String shortenUrl);

    String getBaseUrl(String shortenUrl);

    String getShortenUrl(String originUrl);

    int getMaxIndex();

    int isEmptyTable();
}
