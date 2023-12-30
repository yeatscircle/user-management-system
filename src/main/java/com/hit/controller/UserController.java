package com.hit.controller;

import com.hit.annotation.Log;
import com.hit.pojo.Result;
import com.hit.pojo.User;
import com.hit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basic/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询自己的履历
     *
     * @param JWT
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.GET, value = "/self")
    public Result selectSelf(@RequestHeader("token") String JWT) {
        User user = userService.selectById(JWT);
        return Result.success(user);
    }

    /**
     * 进行履历数据更新--自更新
     *
     * @param user
     * @param JWT
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.PUT)
    public Result updateById(@RequestBody User user, @RequestHeader("token") String JWT) {
        userService.updateById(user, JWT);
        return Result.success();
    }

    /**
     * 上传履历
     *
     * @param user
     * @return
     */
    @Log
    @RequestMapping(method = RequestMethod.POST)
    public Result addUser(@RequestBody User user, @RequestHeader("token") String JWT) {
        userService.addUser(user, JWT);
        return Result.success();
    }
}
