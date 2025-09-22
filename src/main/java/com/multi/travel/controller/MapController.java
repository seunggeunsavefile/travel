package com.multi.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/kakao")
    public String kakao() {
        return "kakaodbIndex"; // Thymeleaf view
    }

}
