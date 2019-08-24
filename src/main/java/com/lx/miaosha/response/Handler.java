package com.lx.miaosha.response;

import com.lx.miaosha.response.error.impl.BusinessException;
import com.lx.miaosha.response.error.impl.EmBusinessError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Handler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception e){
        Map<String,Object> responseDate=new HashMap<>();
        if(e instanceof BusinessException){
            BusinessException businessException=(BusinessException)e;
            responseDate.put("errCode",businessException.getErrCode());
            responseDate.put("errMsg",businessException.getErrMsg());

        }
        else{
            responseDate.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseDate.put("errMsg",EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(responseDate,"fail");

    }
}
