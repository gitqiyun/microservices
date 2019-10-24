package com.qy.shopmember.manage;

import com.qq.connect.QQConnectException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qiyun
 * @date 2019/10/24
 * @描述
 */
public interface QQLoginManage {

    /**
     * 跳转到QQ授权地址
     * @param request
     * @param response
     */
    void locaQQLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * QQ回调地址,内部系统具体业务处理，一般跳转到普通登录后的页面
     *
     * @param request
     * @return
     */
    String qqLoginCallback(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response);

}
