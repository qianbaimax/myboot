package com.xieyue.security.service;

import com.xieyue.security.domain.ResponseResult;
import com.xieyue.security.domain.User;

/**
 * @author longchen
 * @version 2022/8/6 16:48:09
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
