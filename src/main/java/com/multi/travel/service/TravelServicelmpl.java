package com.multi.travel.service;

import com.multi.travel.dto.TravelDTO;
import com.multi.travel.mapper.TravelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServicelmpl implements TravelService {

    private final TravelMapper travelMapper;

    public TravelServicelmpl(TravelMapper travelMapper) {
        this.travelMapper = travelMapper;
    }

    @Override
    public List<TravelDTO> getAllTravel(int page, int size, String query) {
        int offset = (page - 1) * size;
        return travelMapper.findAll(offset, size, query);
    }

    @Override
    public int getTotalCount(String query) {
        return travelMapper.countAll(query);
    }

    @Override
    public List<TravelDTO> getAll() {
        return List.of();
    }

    @Override
    public TravelDTO getOne(int no) {
        return null;
    }
}