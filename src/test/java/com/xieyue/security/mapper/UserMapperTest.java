package com.xieyue.security.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xieyue.security.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author longchen
 * @version 2022/8/1 22:37:19
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");

        System.out.println(passwordEncoder.matches("123456", "$2a$10$sRPUY9S0TTTuiF8A4GC6a.Ma6z/SzCLekcGUX4QVZympQ/CCy4156"));
        System.out.println(passwordEncoder.matches("123456", "$2a$10$cKTJHbON2C/51GOU4UXlQ.vUCjpb9xP7nYhu/ladyzqoLO/cM9qde"));
        System.out.println(encode1);
        System.out.println(encode2);
    }


    @Test
    public void testUserMapper(){

        // 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,"三更半夜");
        User user = userMapper.selectOne(queryWrapper);
//        List<User> users = userMapper.selectList(null);
        System.out.println(user);
    }
}