package com.hit.service.impl;

import com.hit.mapper.UserMapper;
import com.hit.pojo.User;
import com.hit.service.UserService;
import com.hit.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectById(String jwt) {
        Integer id = JwtUtils.GetId(jwt);
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public void deleteByIds(List<Integer> UserIds) {
        userMapper.deleteByIds(UserIds);
    }

    @Override
    public void updateById(User user, String jwt) {
        Integer UserId = JwtUtils.GetId(jwt);
        user.setUserId(UserId);
        userMapper.updateById(user);
    }

    @Override
    public void addUser(User user, String JWT) {
        Integer UserId = JwtUtils.GetId(JWT);
        user.setUserId(UserId);
        userMapper.addUser(user);
    }
}
