package com.yggdrasil.api.user;

import com.yggdrasil.api.user.domain.UserInfo;
import com.yggdrasil.exception.LoginRefuseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void assertUserByNamePassword(String userName, String userPassword) {

        if (!Optional.ofNullable(userMapper.findUserByUserName(userName)).orElseThrow(() -> new LoginRefuseException("用户名或密码错误")).getPassword().equals(userPassword)) {
            throw new LoginRefuseException("账号或者密码错误");
        }


    }
}

