package com.mrkb.common.util;

import java.io.Serializable;

/**
 * 请求返回类型
 */
public  class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = -7576926819530318554L;

    private Boolean isSuccess = true;

    private String errorCode;

    private String message;

    private T data;

    public ResponseData() {
        super();
    }

    public ResponseData(Boolean isSuccess, T data) {
        super();
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public ResponseData(Boolean isSuccess, String errorCode, String message) {
        super();
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResponseData(Boolean isSuccess, String errorCode, String message, T data) {
        super();
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseData failure(String message) {
        this.setIsSuccess(false);
        this.setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "isSuccess=" + isSuccess +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
