package com.lx.miaosha.response.error.impl;

import com.lx.miaosha.response.error.CommonError;

public enum EmBusinessError implements CommonError {
    //通用错误类型10001
    PARAMETER_VAUDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    //20000开头为用户相关错误定义
    USER_NOT_EXIST(20001,"用户不存在")

    ;
    private EmBusinessError(int errCode,String errMsg)
    {
        this.errCode=errCode;
        this.errMsg=errMsg;
    }


    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg=errMsg;
        return this;
    }
}
