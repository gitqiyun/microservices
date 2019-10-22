package com.qy.shopmessages.manage.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qy.shopmessages.manage.MqProducer;
import com.qy.shopmessages.manage.MailManage;
import com.qy.shopmessages.model.Mail;
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
//添加事务则和数据库有关，获取事务则必须能连接上数据库，获取事务是再执行MailManageImpl代理类的代理方法如sendMail等方法前
//获取事务的，如果没有连接数据库那么则会异常则会执行不了sendMail等方法，所以只是测试mail没有连接数据库则不能添加Transactional
public class MailManageImpl implements MailManage {

    @Autowired
    MqProducer mqProducer;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${messages.mail_queue}")
    private String MAIL_QUEUE;

    @Override
    public void sendMail(Mail mail) {

        String from = mail.getFrom();
        String to = mail.getTo();
        String subject = mail.getSubject();
        String text = mail.getText();
        //todo 验证
        // 发送邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }

    @Override
    public void sendMail2Mq(String json) {
 /*       Destination destination = new ActiveMQQueue(MAIL_QUEUE);
        mqProducer.send(destination, json);*/
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
