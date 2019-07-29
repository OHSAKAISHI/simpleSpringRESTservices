package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.entity.UsersEntity;

@Mapper
@Component
public interface UsersMapper {
    List<UsersEntity> findUserList();
}