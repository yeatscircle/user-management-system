package com.hit.pojo;

import java.util.Date;

public class User {
    private Integer id;
    private Integer userId;  //用户id
    private String name;  //使用者姓名
    private Short gender;  //性别:1为男生,2为女生
    private Date birthday;  //生日
    private Short job;  //工作:1为教师,2为公务员,3为程序员
    private String introduction;  //个人简介


    public User() {
    }

    public User(Integer id, Integer userId, String name, Short gender, Date birthday, Short job, String introduction) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.job = job;
        this.introduction = introduction;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public Short getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Short gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return job
     */
    public Short getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(Short job) {
        this.job = job;
    }

    /**
     * 获取
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String toString() {
        return "User{id = " + id + ", userId = " + userId + ", name = " + name + ", gender = " + gender + ", birthday = " + birthday + ", job = " + job + ", introduction = " + introduction + "}";
    }
}
