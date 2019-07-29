package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;

import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.entity.City;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CityMapper cityMapper;

    private final SqlSession sqlSession;

    @GetMapping("/searchcity")
    public String index() {
        City city1 = cityMapper.findByState("CA");
        City city2 = sqlSession.selectOne("com.example.demo.mapper.CityMapper.findByState", "CA");
        return "Greetings from Spring Boot!";
    }
}