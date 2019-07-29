package com.example.demo.model;

import com.example.demo.mapper.entity.UsersEntity;

import lombok.Value;

@Value
public class SampleResponse {
    private Integer userId;
    private String userName;

	public static SampleResponse create(UsersEntity entity) {  // (5)
        return new SampleResponse(
                entity.getUserId(),
                entity.getUserName()
        );
    }
}