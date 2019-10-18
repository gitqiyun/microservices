
package com.qy.shopmessages.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * 
 * @classDesc: 功能描述:(消费消息 mq 从队列获取最新消息)
 */
@Component
public class MqConsumer {

	@Autowired
    MailManage sendMailManage;

	@JmsListener(destination = "mail_queue")
	public void mailReceiver(String json) {
		sendMailManage.sendMail(json);
	}

}
