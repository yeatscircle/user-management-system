package com.hit.controller;

import com.hit.annotation.Log;
import com.hit.pojo.Result;
import com.hit.pojo.UserBasicInformation;
import com.hit.service.UserBasicInformationService;
import com.hit.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basic")
public class UserBasicInformationController {
    //依赖注入
    @Autowired
    private UserBasicInformationService userBasicInformationService;

    /**
     * 更新用户基本信息--只能更新自己的内容
     *
     * @param userBasicInformation
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.PUT)
    public Result updateUserInformation(@RequestBody UserBasicInformation userBasicInformation,
                                        @RequestHeader("token") String JWT) {
        userBasicInformationService.updateUserInformation(userBasicInformation, JWT);
        return Result.success();
    }

    /**
     * 利用密钥直接查询用户基本信息
     *
     * @param JWT
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.GET, value = "/self")
    public Result selfSelect(@RequestHeader("token") String JWT) {
        Integer id = JwtUtils.GetId(JWT);
        UserBasicInformation userBasicInformation = userBasicInformationService.selectUserById(id);
        return Result.success(userBasicInformation);
    }
}
