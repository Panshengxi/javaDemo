package com.xing.xing.utils;

import com.xing.xing.response.Result;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code ,String msg){
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        return result;
    }
}

