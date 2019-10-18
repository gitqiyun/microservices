package com.qy.shopmessages;

import org.mybatis.spring.annotation.MapperScan;
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

    public static void main(String[] args) {
        SpringApplication.run(ShopMessagesApplication.class, args);
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

}

