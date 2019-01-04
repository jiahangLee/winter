package com.winter.demo.handle;

import com.winter.demo.entity.Result;
import com.winter.demo.util.GirlException;
import com.winter.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception e) {
        if(e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            log.error("其他异常={}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
