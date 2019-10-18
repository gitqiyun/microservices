package com.qy.shopmessages.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.qy.shopcommon.globalresult.GlobalResponseResult;
import com.qy.shopmessages.api.model.MailResDto;
import com.qy.shopmessages.api.service.MailService;
import com.qy.shopmessages.manage.MailManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述
 */
@RestController
public class MailServiceImpl implements MailService {

    @Autowired
    MailManage mailManage;

    @Override
    public GlobalResponseResult sendMail( MailResDto mailResDto) {
        try {
            //todo mailResDto验证
            String json= JSON.toJSONString(mailResDto);
            mailManage.sendMail2Mq(json);
            return GlobalResponseResult.setResultSuccess();
        } catch (Exception e) {
            return GlobalResponseResult.setResultError();
        }
    }

    public static void main(String[] args) {
        /*MailResDto mailResDto=new MailResDto();
        mailResDto.setAdress("1114260199@qq.com");
        mailResDto.setContext("哈喽");
        System.out.println(mailResDto);
        String json= JSON.toJSONString(mailResDto);

        JSONObject jsonObject=JSON.parseObject(json);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("adress"));
        System.out.println(jsonObject.getString("context"));
        System.out.println(jsonObject.getString("id"));
        System.out.println(json);*/
    }
}
