package com.qy.shopcommon.globalresult;

import com.qy.shopcommon.constants.ResponseConstants;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述 服务统一返回值处理
 */
public class GlobalResponseResult<T> {
    /**
     * 响应状态吗
     */
    private int rtnCode;
    /**
     * 响应信息
     */
    private String rtnMsg;
    /**
     * 响应数据
     */
    private T data;

    public GlobalResponseResult(int rtnCode, String rtnMsg, T data) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.data = data;
    }

    public int getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Object getData() {
        return data;
    }


    public static GlobalResponseResult<Object> setResultSuccess(Object data) {
        return setResult(ResponseConstants.OK.getRtnCode(), ResponseConstants.OK.getRtnMsg(), data);
    }

    public static GlobalResponseResult<Object> setResultSuccess() {
        return setResultSuccess(null);
    }


    public static GlobalResponseResult<Object> setResultError(String msg) {
        return setResult(ResponseConstants.FAIL.getRtnCode(), msg, null);
    }

    public static GlobalResponseResult<Object> setResultError() {
        return setResultError(null);
    }


    public static GlobalResponseResult<Object> setDefaultResultError() {
        return setResult(ResponseConstants.FAIL.getRtnCode(), ResponseConstants.FAIL.getRtnMsg(), null);
    }

    public static GlobalResponseResult<Object> setResult(int rtnCode, String rtnMsg, Object data) {
        return new GlobalResponseResult<>(rtnCode, rtnMsg, data);
    }
}
