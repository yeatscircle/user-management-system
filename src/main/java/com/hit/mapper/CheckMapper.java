package com.hit.mapper;

import com.hit.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckMapper{
    @Select("select * from administrator where name = #{name}")
    public Administrator check(String name);
}
