package com.drip.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drip.domain.User;
import com.drip.mapper.UserMapper;
import com.drip.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author qq316
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2024-05-15 17:12:53
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




