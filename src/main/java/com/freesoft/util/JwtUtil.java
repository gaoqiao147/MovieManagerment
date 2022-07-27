package com.freesoft.util;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhouwei
 */
public class JwtUtil {
    private static long time = 1000 * 60 * 60 * 24 * 15;
    private static String signature = "admin";

    public static String createToken(String nickname) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("nickname", nickname)
                .setSubject("wisdom_reservoir")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }

    public static String getToken(String token) throws Exception {
        Jws<Claims> claimsJws = null;
        if (token == null) {
            throw new Exception();
        }
        try {
            claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Claims claims = claimsJws.getBody();
        String nickname = (String) claims.get("nickname");
        return nickname;
    }

    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(signature).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效，从请求头中获取token
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(signature).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取用户信息 从请求头中获取token
     *
     * @param request
     * @return
     */
    public static String getMemberNickNameByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody(); // 得到用户数据的主体
        return (String) claims.get("nickname");
    }
}
