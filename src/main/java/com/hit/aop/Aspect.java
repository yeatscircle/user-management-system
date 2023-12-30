package com.hit.aop;

import com.alibaba.fastjson.JSONObject;
import com.hit.mapper.CheckMapper;
import com.hit.mapper.OperateLogMapper;
import com.hit.pojo.Administrator;
import com.hit.pojo.OperateLog;
import com.hit.pojo.Result;
import com.hit.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    @Autowired
    OperateLogMapper operateLogMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    CheckMapper checkMapper;

    @Around("execution(* com.hit.controller.AdministratorController.*(..))")
    public Object Check(ProceedingJoinPoint joinPoint) throws Throwable {
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        String name = (String) claims.get("name");
        Administrator administrator = checkMapper.check(name);
        if(administrator!=null) {
            Object result = joinPoint.proceed();
            return result;
        }
        return Result.error("你没有管理员权限");
    }

    @Around("@annotation(com.hit.annotation.Log)")
    public Object MyLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //设置操作人id
        String jwt = httpServletRequest.getHeader("token");
        Integer operateUser = JwtUtils.GetId(jwt);

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        //方法执行
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //方法返回值
        String resultValue = JSONObject.toJSONString(result);

        //方法用时
        Long costTime = end-begin;

        //记录日志

        OperateLog Logger = new OperateLog(null,operateUser,operateTime,className,methodName,
                methodParams,resultValue,costTime);
        operateLogMapper.insert(Logger);
        return result;
    }
}
