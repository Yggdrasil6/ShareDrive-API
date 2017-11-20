package com.yggdrasil.api.user;

import com.yggdrasil.api.user.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{name}")
    UserInfo findUserByUserName(String name);

    @Select("select * from user where email=#{email}")
    UserInfo findUserByUserEmail(String email);


}
