
package com.hit.pojo;

import java.time.LocalDateTime;

public class OperateLog {
    private Integer id; //ID
    private Integer operateUser; //操作人ID
    private LocalDateTime operateTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
    private Long costTime; //操作耗时

    public OperateLog() {
    }

    public OperateLog(Integer id, Integer operateUser, LocalDateTime operateTime, String className, String methodName, String methodParams, String returnValue, Long costTime) {
        this.id = id;
        this.operateUser = operateUser;
        this.operateTime = operateTime;
        this.className = className;
        this.methodName = methodName;
        this.methodParams = methodParams;
        this.returnValue = returnValue;
        this.costTime = costTime;
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
     * @return operateUser
     */
    public Integer getOperateUser() {
        return operateUser;
    }

    /**
     * 设置
     * @param operateUser
     */
    public void setOperateUser(Integer operateUser) {
        this.operateUser = operateUser;
    }

    /**
     * 获取
     * @return operateTime
     */
    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    /**
     * 设置
     * @param operateTime
     */
    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取
     * @return methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置
     * @param methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取
     * @return methodParams
     */
    public String getMethodParams() {
        return methodParams;
    }

    /**
     * 设置
     * @param methodParams
     */
    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    /**
     * 获取
     * @return returnValue
     */
    public String getReturnValue() {
        return returnValue;
    }

    /**
     * 设置
     * @param returnValue
     */
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    /**
     * 获取
     * @return costTime
     */
    public Long getCostTime() {
        return costTime;
    }

    /**
     * 设置
     * @param costTime
     */
    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public String toString() {
        return "OperateLog{id = " + id + ", operateUser = " + operateUser + ", operateTime = " + operateTime + ", className = " + className + ", methodName = " + methodName + ", methodParams = " + methodParams + ", returnValue = " + returnValue + ", costTime = " + costTime + "}";
    }
}
