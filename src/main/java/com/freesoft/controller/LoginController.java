package com.freesoft.controller;

import com.freesoft.model.MovieUserinfoDO;
import com.freesoft.service.MovieUserinfoService;
import com.freesoft.util.JwtUtil;
import com.freesoft.util.WebUtils;
import io.swagger.annotations.Api;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouwei
 */
@RestController
@Api(value = "登录接口")
@RequestMapping("/system")
public class LoginController {
    @Resource
    private MovieUserinfoService movieUserinfoService;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestParam("nickname") String nickname, @RequestParam("password") String password, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        String ps = new Md5Hash(password, "salt", 2).toString();
        MovieUserinfoDO user = movieUserinfoService.queryUserByName(nickname);
        if (user != null) {
            String pwd = user.getPassword();
            if (ps.equals(pwd)) {
                WebUtils.getSession().setAttribute("user", user);
                map.put("msg", "登陆成功");
                map.put("code", 1);
                map.put("token", JwtUtil.createToken(user.getUsername()));
            } else {
                map.put("msg", "密码错误");
                map.put("code", 0);
            }
        } else {
            map.put("msg", "账号不存在");
            map.put("code", 0);
        }
        return map;
    }
}
