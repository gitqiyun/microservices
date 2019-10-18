package com.qy.shopmember;

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
@MapperScan("com.qy.shopmember.mapper")
@RestController
public class ShopMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopMemberApplication.class, args);
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

}

