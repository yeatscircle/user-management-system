package com.hit.pojo;


import java.time.LocalDateTime;


public class UserBasicInformation {
    private Integer id;
    private String username; //用户名
    private String password;  //密码
    private LocalDateTime createTime;  //创建时间
    private LocalDateTime updateTime;  //更新时间

    public UserBasicInformation() {
    }

    public UserBasicInformation(Integer id, String username, String password, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "UserBasicInformation{id = " + id + ", username = " + username + ", password = " + password + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}
