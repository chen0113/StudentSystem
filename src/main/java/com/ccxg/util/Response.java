package com.ccxg.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonSerialize
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -7595286461590651149L;

    /**
     * 请求成功返回码
     */
    private static final String sucessCode = "1";

    /**
     * 返回的数据
     */
    private T charData;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回描述
     */
    private String msg;

    public Response() {
        this.code = sucessCode;
        this.msg = "请求成功";
    }

    public Response(String code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, T data) {
        this();
        this.code = code;
        this.msg = msg;
        this.charData = data;
    }

    public Response(T data) {
        this();
        this.charData = data;
    }
}
