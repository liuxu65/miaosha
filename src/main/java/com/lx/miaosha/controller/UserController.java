package com.lx.miaosha.controller;


import com.lx.miaosha.model.UserModel;
import com.lx.miaosha.response.CommonReturnType;
import com.lx.miaosha.response.Handler;
import com.lx.miaosha.response.error.impl.BusinessException;
import com.lx.miaosha.response.error.impl.EmBusinessError;
import com.lx.miaosha.service.UserService;
import com.lx.miaosha.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class UserController extends Handler {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/getOtp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone")String telphone){
        //需要按照一定的规则生成OTP验证码
        Random random=new Random();
        int randomInt=random.nextInt(99999);
        randomInt+=10000;
        String otpCode=String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联【Redis】
        httpServletRequest.getSession().setAttribute(telphone,otpCode);

        //将OTP验证码通过短信通道发送给用户【省略】
        System.out.println("telphone="+telphone+"&optCode="+otpCode);

        return CommonReturnType.create(null);
    }


    @GetMapping("/user/{id}")
    public CommonReturnType getUser(@PathVariable("id") Integer id ) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if(userModel==null)
        {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        else{
            //返回通用对象
            UserVO userVO = convertFromMode(userModel);
            return CommonReturnType.create(userVO);
        }
    }
    private UserVO convertFromMode(UserModel userModel){
        if(userModel==null)
        {
            return null;
        }
        else
        {
            UserVO userVO=new UserVO();
            BeanUtils.copyProperties(userModel,userVO);
            return userVO;
        }
    }

}
