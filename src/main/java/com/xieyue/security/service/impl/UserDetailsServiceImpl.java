package com.xieyue.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyue.security.domain.LoginUser;
import com.xieyue.security.domain.User;
import com.xieyue.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author longchen
 * @version 2022/8/6 14:09:10
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        // 如果没有查询到用户信息就跑出异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }


        // todo 查询对应的权限信息
        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        // 把数据封装成UserDetails返回
        return new LoginUser(user,list);
    }
}
