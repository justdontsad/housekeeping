package com.vio.dto;

/**
 * @author vio
 * @date 2020-01-18   00:25
 */
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;

    public ResultVO(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
