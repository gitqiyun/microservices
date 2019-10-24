package com.qy.shopmember.manage.impl;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;
import com.qy.shopmember.manage.QQLoginManage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author qiyun
 * @date 2019/10/24
 * @描述 qq第三方登录
 */
@Service
public class QQLoginManageImpl implements QQLoginManage {


    public void locaQQLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (QQConnectException e) {
            e.printStackTrace();
        }

    }


    public String qqLoginCallback(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response)  {
        String result="success";
        // 先获取accessToken
        AccessToken accessTokenObj = null;
        try {
            accessTokenObj = new Oauth().getAccessTokenByRequest(request);
        } catch (QQConnectException e) {
            result="error";
        }
        if (accessTokenObj == null) {
            result="error";
        }
        String accessToken = accessTokenObj.getAccessToken();
        if (StringUtils.isEmpty(accessToken)) {
            result="error";
        }
        // 获取openid
        OpenID openIdObj = new OpenID(accessToken);
        try {
            String userOpenID = openIdObj.getUserOpenID();
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        // 使用openid查找用户信息是否绑定
           /* Map<String, Object> openIdMap = userFeign.findLogin(userOpenID);
            Integer code = (Integer) openIdMap.get(BaseApiConstants.HTTP_CODE_NAME);
            // 判断是否绑定会员
            if (code.equals(BaseApiConstants.HTTP_200_CODE)) {
                // 已经授权过,自动登录
                String token = (String) openIdMap.get("data");
                CookieUtil.addCookie(response, Constants.USER_TOKEN, token,
                        Constants.WEBUSER_COOKIE_TOKEN_TERMVALIDITY);
                return INDEX;
            }
            // 没有绑定openid
            httpSession.setAttribute("openid", userOpenID);*/
           return result;
    }


}
