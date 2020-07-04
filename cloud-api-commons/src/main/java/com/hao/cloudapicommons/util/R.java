package com.hao.cloudapicommons.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 *响应信息主体
 * @param <T>
 */
public class R<T> implements Serializable {

    private int code;//返回标记：成功标记=0，失败标记=1
    private String msg;//返回信息
    private T data;//数据

     Integer FAIL = 1;
     Integer SUCCESS = 0;

    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS.equals(this.getCode());
    }

    public static <T> R<T> ok() {
        return restResult(null, 0, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, 0, (String)null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, 0, msg);
    }

    public static <T> R<T> ok(T data, boolean detail) {
        return restResult(data, 0, (String)null);
    }

    public static <T> R<T> ok(T data, String msg, boolean detail) {
        return restResult(data, 0, msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, 1, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(null, 1, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data, 1, (String)null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(data, 1, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static <T> R.RBuilder<T> builder() {
        return new R.RBuilder();
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public R<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public R<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static class RBuilder<T> {
        private int code;
        private String msg;
        private T data;

        RBuilder() {
        }

        public R.RBuilder<T> code(int code) {
            this.code = code;
            return this;
        }

        public R.RBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public R.RBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public R<T> build() {
            return new R(this.code, this.msg, this.data);
        }

        public String toString() {
            return "R.RBuilder(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
        }
    }


}
