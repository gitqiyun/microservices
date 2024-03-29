package com.qy.shoppay.controller;

import com.qy.shoppay.manage.UnionPayManage;
import com.qy.shoppay.model.PaymentInfo;
import com.unionpay.acp.sdk.DemoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qiyun
 * @date 2019/10/29
 * @描述
 */
@Controller
@RequestMapping("/union")
public class UnionPayController {

    @Autowired
    UnionPayManage unionPayManage;

    /**
     * 支付
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/pay", method = {RequestMethod.POST, RequestMethod.GET})
    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException{

        unionPayManage.pay(request, response);

    }

    /**
     * 后台回调
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/backRcvResponse", method = {RequestMethod.GET, RequestMethod.POST})
    public void backRcvResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {

        unionPayManage.backRcvResponse(request, response);

    }

    /**
     * 前台回调
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/frontRcvResponse", method = {RequestMethod.GET, RequestMethod.POST})
    public void frontRcvResponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        unionPayManage.frontRcvResponse(request, response);

    }

    /**
     * 成功后跳转
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/successRedict", method = RequestMethod.POST)
    public void successRedict(HttpServletRequest request, HttpServletResponse response) throws IOException {

        unionPayManage.successRedict(request, response);

    }

    /**
     * 查询、检查交易状态
     * @param request
     * @param response
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {

        unionPayManage.query(request, response);

    }
/*
    *//**
     * 交易状态查询
     * @param orderId
     *//*
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public JsonResult check(Long orderId) {

        try {
            service.check(orderId);
            return JsonResult.resultSuccess("已支付", "");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.resultError("未发现支付信息");
        }

    }*/

}
