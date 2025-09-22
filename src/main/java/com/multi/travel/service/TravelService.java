package com.multi.travel.service;

import com.multi.travel.dto.TravelDTO;
import java.util.List;

public interface TravelService {
    List<TravelDTO> getAllTravel(int page, int size, String query);
    int getTotalCount(String query);

    List<TravelDTO> getAll();

    TravelDTO getOne(int no);
}