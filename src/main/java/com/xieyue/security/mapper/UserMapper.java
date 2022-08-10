package com.xieyue.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xieyue.security.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author longchen
 * @version 2022/8/1 22:33:45
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
