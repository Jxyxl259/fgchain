package com.fgchain.main.module.common;

public enum GlobalMessageEnum {

    SUCCESS(0,"成功");

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
