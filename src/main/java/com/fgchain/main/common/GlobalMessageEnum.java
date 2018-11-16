package com.fgchain.main.common;

public enum GlobalMessageEnum {
    SUCCESS("000000", "操作成功"),
    EMPTY_DATA("111111", "未查询到相关数据"),
    FAILED("999999", "操作失败"),
    SYSTEM_ERROR("999999", "系统错误");


    private String status_code;
    private String message;

    GlobalMessageEnum(String status_code, String message) {
        this.status_code = status_code;
        this.message = message;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
