package com.hit.controller;

import com.hit.pojo.PageBean;
import com.hit.pojo.Result;
import com.hit.pojo.User;
import com.hit.pojo.UserBasicInformation;
import com.hit.service.UserBasicInformationService;
import com.hit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Adm")
public class AdministratorController {
    //依赖注入
    @Autowired
    private UserBasicInformationService userBasicInformationService;

    @Autowired
    UserService userService;

    /**
     * 根据id批量删除用户,同时删去履历对应的部分--管理员专用
     *
     * @param ids
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ids}")
    public Result deleteUserById(@PathVariable List<Integer> ids) {
        userBasicInformationService.deleteUserById(ids);
        return Result.success();
    }

    /**
     * 自定义搜索查询,可以直接进行无参数搜索
     *
     * @param page
     * @param pageSize
     * @param username
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result selectUsers(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              String username,
                              @DateTimeFormat(pattern = "yyyy-mm--dd") LocalDateTime begin,
                              @DateTimeFormat(pattern = "yyyy-mm--dd") LocalDateTime end) {
        PageBean pageBean = userBasicInformationService.selectUsers(page, pageSize, username, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 根据id查询用户基本信息
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Result selectUserById(@PathVariable Integer id) {
        UserBasicInformation userBasicInformation = userBasicInformationService.selectUserById(id);
        return Result.success(userBasicInformation);
    }

    /**
     * 查看指定人的履历--id为基本信息的表中的id而非user履历表的id
     *
     * @param UserId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/user/{UserId}")
    public Result selectByIds(@PathVariable Integer UserId) {
        User user = userService.selectById(UserId.toString());
        return Result.success(user);
    }

    /**
     * 管理员权限
     * 根据id进行批量删除履历,id的内容同上
     *
     * @param UserIds
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{UserIds}")
    public Result deleteByIds(@PathVariable List<Integer> UserIds) {
        userService.deleteByIds(UserIds);
        return Result.success();
    }
}
