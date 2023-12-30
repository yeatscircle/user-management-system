package com.hit.controller;

import com.hit.annotation.Log;
import com.hit.pojo.Result;
import com.hit.service.UserBasicInformationService;
import com.hit.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    UserBasicInformationService userBasicInformationService;

    /**
     * 直接进行用户注销--根据jwt令牌识别即可,无需进行其他参数传递
     * @param jwt
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.DELETE)
    public Result logout(@RequestHeader("token") String jwt){
        Integer id = JwtUtils.GetId(jwt);
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        userBasicInformationService.deleteUserById(ids);
        return Result.success();
    }
}
