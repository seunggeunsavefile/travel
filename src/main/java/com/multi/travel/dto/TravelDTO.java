package com.multi.travel.dto;

import lombok.Data;

@Data
public class TravelDTO {
    private int no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;
    private Double lat;
    private Double lng;
    private String imageUrl;     // 대표 이미지
    private String extraImage;   // 추가 갤러리 이미지
}