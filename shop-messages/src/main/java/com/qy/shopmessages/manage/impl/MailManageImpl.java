package com.qy.shopmessages.manage.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qy.shopmessages.manage.MqProducer;
import com.qy.shopmessages.manage.MailManage;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;

/**
 * @author qiyun
 * @date 2019/10/18
 * @描述
 */
@Service
@Transactional
public class MailManageImpl implements MailManage {

    @Autowired
    MqProducer mqProducer;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${messages.mail_queue}")
    private String MAIL_QUEUE;

    @Override
    public void sendMail(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String from = jsonObject.getString("from");
        String to = jsonObject.getString("to");
        String subject = jsonObject.getString("subject");
        String text = jsonObject.getString("text");
        //todo 验证
        // 发送邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to); // 自己给自己发送邮件
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }

    @Override
    public void sendMail2Mq(String json) {
        Destination destination = new ActiveMQQueue(MAIL_QUEUE);
        mqProducer.send(destination, json);
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content) {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {

    }


}
