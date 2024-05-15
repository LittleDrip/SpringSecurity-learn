package com.drip.service;

import com.drip.domain.User;
import com.drip.utils.Result;

public interface LoginService {
    Result login(User user);
}
