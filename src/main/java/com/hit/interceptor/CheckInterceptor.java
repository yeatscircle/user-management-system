package com.hit.interceptor;

import com.hit.mapper.CheckMapper;
import com.hit.pojo.Administrator;
import com.hit.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CheckInterceptor implements HandlerInterceptor {
    @Autowired
    CheckMapper checkMapper;

    //true放行,false不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        String name = (String) claims.get("name");
        Administrator administrator = checkMapper.check(name);
        if(administrator!=null)
            return true;
        return false;
    }
}
