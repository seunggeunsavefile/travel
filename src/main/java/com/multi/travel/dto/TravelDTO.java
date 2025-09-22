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
}