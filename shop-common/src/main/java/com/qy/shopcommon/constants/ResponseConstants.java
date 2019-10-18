package com.qy.shopcommon.constants;

/**
 * @author qiyun
 * @date 2019/10/17
 * @描述 请求响应状态枚举
 */
public enum ResponseConstants {
        OK(200,"成功"),
        FAIL(500,"内部错误"),
        NOT_AUTHENCATION(302,"登陆过期"),
        NOT_FOUND(404, "请求路径不正确"),
        FORBIDDEN(403, "禁止访问"),
        BAD_REQUEST(400, "请求无效"),
        BAD_CREDENTIALS(301, "账号或密码错误"),
        BAD_BONDCODES(700,"债券代码不合法或者不存在");

        private int rtnCode;
        private String rtnMsg;

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

        ResponseConstants(int rtnCode, String rtnMsg) {
            this.rtnCode = rtnCode;
            this.rtnMsg = rtnMsg;
        }
}
