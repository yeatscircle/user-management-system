package com.hit.mapper;

import com.hit.pojo.UserBasicInformation;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;


@Mapper
public interface UserBasicInformationMapper {

    void register(UserBasicInformation userBasicInformation);

    UserBasicInformation login(UserBasicInformation user);

    UserBasicInformation selectUserById(Integer id);

    void updateUserInformation(UserBasicInformation userBasicInformation);

    void deleteUserById(List<Integer> ids);

    List<UserBasicInformation> selectByPageHelper(String username, LocalDateTime begin, LocalDateTime end);
}
