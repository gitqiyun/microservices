package com.qy.shopmember;

import com.qy.shopmember.manage.QQLoginManage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述
 */
@SpringBootApplication
@MapperScan("com.qy.shopmember.mapper")
@RestController
public class ShopMemberApplication {

    @Autowired
    QQLoginManage qqLoginManage;

    public static void main(String[] args) {
        SpringApplication.run(ShopMemberApplication.class, args);
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/qqLogin")
    public void qqLogin(HttpServletRequest request,HttpServletResponse response){
         qqLoginManage.locaQQLogin(request,response);
    }

    @GetMapping("/qqLoginCallback")
    public String qqLoginCallback(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response){
        qqLoginManage.qqLoginCallback(request,httpSession,response);
        return "success";
    }


}

