package com.drip.service.impl;

import com.drip.domain.LoginUser;
import com.drip.domain.User;
import com.drip.service.LoginService;
import com.drip.utils.JwtUtil;
import com.drip.utils.RedisCache;
import com.drip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;
    @Override
    public Result login(User user) {
//        使用AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);//开始校验 会在UserDetails里查询 之后会在provider进行密码校验 最后再返回
//        没通过 给出提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
//        通过 使用userid生成jwt userid在被authenticate里封装着
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        Map map=new HashMap();
        map.put("token",jwt);
//        将用户信息存入redis，userid当做key
        redisCache.setCacheObject("login:"+id,loginUser);
        return Result.ok(map);
    }
}
