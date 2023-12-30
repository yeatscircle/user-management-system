package com.hit.mapper;

import com.hit.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectById(Integer id);

    void deleteByIds(List<Integer> UserIds);

    void updateById(User user);

    void addUser(User user);
}
