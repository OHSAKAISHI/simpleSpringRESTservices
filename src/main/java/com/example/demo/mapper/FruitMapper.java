package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.mapper.entity.Fruit;

@Mapper
public interface FruitMapper {
	List<Fruit> selectAll();
	void insert(String name);
	void delete(String name);
	void update(String before_name, String after_name);
}