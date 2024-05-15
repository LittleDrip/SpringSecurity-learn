package com.drip.test;

import com.drip.domain.User;
import com.drip.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class TokenTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }

    @Test
    public void testBCryptPasswordEncoder(){

        String encode = bCryptPasswordEncoder.encode("1234");
        System.out.println("encode = " + encode);
//        $2a$10$rP3w782bcE0mYszzjv6JMOXu/Y4XB2WXYBGyfWX0ozAZtHhlYWfWi
        boolean matches = bCryptPasswordEncoder.matches("1234", "$2a$10$rP3w782bcE0mYszzjv6JMOXu/Y4XB2WXYBGyfWX0ozAZtHhlYWfWi");
        System.out.println("matches = " + matches);
    }
}
