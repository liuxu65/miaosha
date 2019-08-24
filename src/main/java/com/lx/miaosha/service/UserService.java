package com.lx.miaosha.service;

import com.lx.miaosha.model.UserModel;

public interface UserService {
    //通过用户id查询信息
    UserModel getUserById(Integer id);
}
