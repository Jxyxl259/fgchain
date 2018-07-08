package com.fgchain.main.module.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: RequestResult工厂类
 * @author: jiangxy
 * @create: 2018-07-07 22:37
 */
public class RequestResultFactory {


    private static RequestResult sucess = new RequestResult(true);

    static {
        sucess.setResultCode(String.valueOf(GlobalMessageEnum.SUCCESS.getCode()));
        sucess.setResultMsg(GlobalMessageEnum.SUCCESS.getCommon());
    }


    public static RequestResult success(){
        return sucess;
    }


    public static <T> RequestResult<T> success(T t){
        RequestResult res = new RequestResult(true);
        res.setResultCode(String.valueOf(GlobalMessageEnum.SUCCESS.getCode()));
        res.setT(t);
        return res;
    }


    public static RequestResult Global(String Global){
        RequestResult res = new RequestResult(false);
        res.setResultMsg(Global);
        return res;
    }


    public static RequestResult Global(GlobalMessageEnum Global){
        RequestResult res = new RequestResult(false);
        res.setResultCode(String.valueOf(Global.getCode()));
        res.setResultMsg(Global.getCommon());
        return res;
    }

    public static RequestResult Global(GlobalMessageEnum Global,String reason){
        RequestResult res = new RequestResult(false);
        res.setResultCode(String.valueOf(Global.getCode()));
        res.setResultMsg(Global.getCommon());
        if(StringUtils.isNotBlank(reason)){
            res.setResultMsg(reason);
        }
        return res;
    }

    public static RequestResult Global(String code, String message){
        RequestResult res = new RequestResult(false);
        res.setResultCode(code);
        res.setResultMsg(message);
        return res;
    }

}
