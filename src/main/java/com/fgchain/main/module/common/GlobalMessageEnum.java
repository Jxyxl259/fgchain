package com.fgchain.main.module.common;

public enum GlobalMessageEnum {

    SUCCESS(0,"成功"),
    LOGIN_SUCCESS(0,"登陆成功"),
    EXCESSIVE_LOGIN_TYR(9001,"密码尝试次数过多"),
    NO_SUCH_ACCOUNT(9002, "该用户不存在"),
    ERROR_USERNAME_OR_PASSWORD(9003, "用户名或密码错误"),
    AUTHENTICATION_ERROR(9005,"用户认证错误");


    private Integer code;
    private String common;

    GlobalMessageEnum(Integer code, String common) {
        this.code = code;
        this.common = common;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
