package com.lx.miaosha.service.impl;

import com.lx.miaosha.dao.UserDOMapper;
import com.lx.miaosha.dao.UserPasswordDOMapper;
import com.lx.miaosha.entity.UserDO;
import com.lx.miaosha.entity.UserPasswordDO;
import com.lx.miaosha.model.UserModel;
import com.lx.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if(userDO==null){
            return null;
        }
        //通过用户id获取对应的用户密码
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromEntity(userDO,userPasswordDO);
    }
    private UserModel convertFromEntity(UserDO userDO, UserPasswordDO userPasswordDO)
    {
        if(userDO==null){
            return null;
        }
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        if(userPasswordDO==null){
            return null;
        }
        userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        return userModel;
    }
}
