package com.multi.travel.controller;

import com.multi.travel.dto.TravelDTO;
import com.multi.travel.service.TravelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TravelRestController {

    private final TravelService travelService;

    public TravelRestController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/api/travels")
    public Map<String, Object> getTravels(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String query
    ) {
        List<TravelDTO> list = travelService.getAllTravel(page, size, query);
        int totalCount = travelService.getTotalCount(query);
        int totalPages = (int) Math.ceil((double) totalCount / size);

        Map<String, Object> result = new HashMap<>();
        result.put("travels", list);
        result.put("totalPages", totalPages);
        result.put("currentPage", page);
        return result;
    }
}