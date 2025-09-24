package com.multi.travel.dao;

import com.multi.travel.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TravelDAO {

    @Select("SELECT no, district, title, description, address, phone, lat, lng, imageUrl,extraImage FROM travel")
    List<TravelDTO> selectAll();
}
