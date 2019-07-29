package com.example.demo.mapper.entity;

import lombok.Data;

@Data  // (3)
public class UsersEntity {
    private Integer userId;
    private String userName;
}