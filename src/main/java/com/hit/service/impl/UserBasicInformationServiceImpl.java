package com.hit.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hit.mapper.UserBasicInformationMapper;
import com.hit.mapper.UserMapper;
import com.hit.pojo.PageBean;
import com.hit.pojo.UserBasicInformation;
import com.hit.service.UserBasicInformationService;
import com.hit.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserBasicInformationServiceImpl implements UserBasicInformationService {
    @Autowired
    UserBasicInformationMapper userBasicInformationMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserBasicInformation login(UserBasicInformation user) {
        return userBasicInformationMapper.login(user);
    }

    @Override
    public void updateUserInformation(UserBasicInformation userBasicInformation, String JWT) {
        userBasicInformation.setId(JwtUtils.GetId(JWT));
        userBasicInformation.setUpdateTime(LocalDateTime.now());
        userBasicInformationMapper.updateUserInformation(userBasicInformation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserById(List<Integer> ids) {
        userBasicInformationMapper.deleteUserById(ids);
        userMapper.deleteByIds(ids);
    }

    @Override
    public PageBean selectUsers(Integer page, Integer pageSize, String username, LocalDateTime begin, LocalDateTime end) {
        //      设置分页参数
        PageHelper.startPage(page, pageSize);
//      执行查询
        List<UserBasicInformation> userList = userBasicInformationMapper.selectByPageHelper(username, begin, end);
        Page<UserBasicInformation> p = (Page<UserBasicInformation>) userList;
//      最后封装到pageBean实体类里面
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void register(UserBasicInformation userBasicInformation) {
        userBasicInformation.setCreateTime(LocalDateTime.now());
        userBasicInformation.setUpdateTime(LocalDateTime.now());
        System.out.println(userBasicInformation);
        userBasicInformationMapper.register(userBasicInformation);
    }

    @Override
    public UserBasicInformation selectUserById(Integer id) {
        UserBasicInformation userBasicInformation = userBasicInformationMapper.selectUserById(id);
        return userBasicInformation;
    }


}
