package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.mapper.entity.UsersEntity;
import com.example.demo.model.SampleResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final UsersMapper usersMapper;  // (1)

    @GetMapping("/get/sample")
    public List<SampleResponse> getSample() {
        List<UsersEntity> usersEntityList = usersMapper.findUserList();  // (2)
    	try{
			Thread.sleep(3000); //10000ミリ秒Sleepする
		}catch(InterruptedException e){}
        return usersEntityList.stream().map(SampleResponse::create).collect(Collectors.toList());  // (3)
    }
}