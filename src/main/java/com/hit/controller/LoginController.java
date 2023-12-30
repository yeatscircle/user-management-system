package com.hit.controller;

import com.hit.annotation.Log;
import com.hit.pojo.Result;
import com.hit.pojo.UserBasicInformation;
import com.hit.service.UserBasicInformationService;
import com.hit.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserBasicInformationService userBasicInformationService;

    /**
     * 登录分发令牌
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result login(@RequestBody UserBasicInformation user) {
        UserBasicInformation u = userBasicInformationService.login(user);
        System.out.println(user);
        //请求成功返回一个jwt令牌
        if(u!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("name",u.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("NOT_LOGIN");
    }
}
