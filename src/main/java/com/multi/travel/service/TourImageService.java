package com.multi.travel.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@Service
public class TourImageService {
    private final String serviceKey = "490dff3a74450adae8e1524024697a4e35ce97f3bb37436d4be589e01bcd36a5";

    public String getImageUrl(String keyword) {
        try {
            String urlStr = "http://apis.data.go.kr/B551011/PhotoGalleryService1/gallerySearchList1"
                    + "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")
                    + "&keyword=" + URLEncoder.encode(keyword, "UTF-8")
                    + "&MobileOS=ETC&MobileApp=AppTest&_type=json&numOfRows=1&pageNo=1";

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(urlStr, String.class);

            JSONObject json = new JSONObject(result);
            JSONArray items = json.getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items")
                    .getJSONArray("item");

            if(items.length() > 0) {
                return items.getJSONObject(0).getString("galWebImageUrl");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

