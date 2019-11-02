package com.xing.xing.response;


/**
 * http请求返回的最外层对象
 */
public class Result<T> {

    //错误码
    private Integer status;

    //提示信息
    private String msg;

    //具体内容
    private  T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {return msg;}

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result getResultData(String msg,Integer code,T data){
        Result result = new Result();
        result.setMsg(msg);
        result.setStatus(code);
        result.setData(data);
        return result;
    }
}

