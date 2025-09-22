package com.multi.travel.mapper;

import com.multi.travel.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {
    List<TravelDTO> findAll(@Param("offset") int offset, @Param("size") int size, @Param("query") String query);
    int countAll(@Param("query") String query);
}