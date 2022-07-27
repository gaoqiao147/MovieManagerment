package com.freesoft.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouwei
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
            // 通过所有OPTION请求
            return true;
        } else {
            // 获取请求头中的token
            String token = request.getHeader("token");
            Map<String, Object> map = new HashMap<>();
            try {
                boolean verify = com.freesoft.util.JwtUtil.checkToken(token);
                if (verify) {
                    // 通过验证
                    return true;
                } else {
                    // 未通过验证
                    return false;
                }
            } catch (SignatureException e) {
                e.printStackTrace();
                map.put("msg", "无效签名");
            } catch (UnsupportedJwtException e) {
                e.printStackTrace();
                map.put("msg", "不支持的签名");
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                map.put("msg", "token过期");
            } catch (MalformedJwtException e) { // IllegalArgumentException
                e.printStackTrace();
                map.put("msg", "不支持的签名格式");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("msg", "token无效");
            }
            map.put("state", false);
            // 将map转为json
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return false;
        }
    }
}
