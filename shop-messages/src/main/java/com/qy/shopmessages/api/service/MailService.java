package com.qy.shopmessages.api.service;

import com.qy.shopcommon.globalresult.GlobalResponseResult;
import com.qy.shopmessages.api.model.MailResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述
 */
@RequestMapping("/mail")
public interface MailService {

    @GetMapping("/send")
    GlobalResponseResult sendMail(@RequestBody MailResDto mailResDto);
}

