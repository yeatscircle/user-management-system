package com.hit.controller;

import com.hit.annotation.Log;
import com.hit.pojo.Result;
import com.hit.pojo.UserBasicInformation;
import com.hit.service.UserBasicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserBasicInformationService userBasicInformationService;

    /**
     * 注册信息
     *
     * @param userBasicInformation
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result register(@RequestBody UserBasicInformation userBasicInformation) {
        userBasicInformationService.register(userBasicInformation);
        return Result.success();
    }
}
