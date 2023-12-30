package com.hit.service;

import com.hit.pojo.User;

import java.util.List;

public interface UserService {

    User selectById(String jwt);

    void deleteByIds(List<Integer> UserIds);

    void updateById(User user, String jwt);

    void addUser(User user, String JWT);
}
