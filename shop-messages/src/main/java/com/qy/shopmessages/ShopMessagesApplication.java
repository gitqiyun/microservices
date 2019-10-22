package com.qy.shopmessages;

import com.qy.shopmessages.manage.MailManage;
import com.qy.shopmessages.model.Mail;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述
 */
@SpringBootApplication
@MapperScan("com.qy.shopmessages.mapper")
@RestController
public class ShopMessagesApplication {

    @Autowired
    MailManage mailManage;

    public static void main(String[] args) {
        SpringApplication.run(ShopMessagesApplication.class, args);
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/mail")
    public String mail(){
        Mail mail =new Mail();
        mail.setFrom("yushengjun644064@163.com");
        mail.setTo("1114260199@qq.com");
        mail.setSubject("testsubject");
        mail.setText("testtext");
        mailManage.sendMail(mail);
        return "success";
    }

}

