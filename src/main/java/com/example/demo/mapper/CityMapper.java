package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.mapper.entity.City;

@Mapper
public interface CityMapper {
    // @Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    City findByState(@Param("state") String state);
}