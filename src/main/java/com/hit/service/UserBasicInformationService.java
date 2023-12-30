package com.hit.service;

import com.hit.pojo.PageBean;
import com.hit.pojo.UserBasicInformation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public interface UserBasicInformationService {
    void register(UserBasicInformation userBasicInformation);

    UserBasicInformation login(UserBasicInformation user);

    UserBasicInformation selectUserById(Integer id);

    void updateUserInformation(UserBasicInformation userBasicInformation, String JWT);

    void deleteUserById(List<Integer> ids);

    PageBean selectUsers(Integer page, Integer pageSize, String username, LocalDateTime begin, LocalDateTime end);
}
