package com.quick.mq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

/**
 * @author hanfucheng
 * @createDate 2021/7/29 20:07:55
 */
public class RabbitUtil {
    public static Channel getRabbitMqConfig() {
        Logger logger = LoggerFactory.getLogger(com.quick.mq.util.RabbitUtil.class);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接地址
        connectionFactory.setHost("192.168.72.128");
        //默认端口，如果报连接异常，需要看下一是否开放了此端口
        connectionFactory.setPort(5672);
        //设置密码用户名
        connectionFactory.setUsername("hfc");
        connectionFactory.setPassword("hfc220");
        //设置虚拟机,每个虚拟机相当于一个小的mq
//        connectionFactory.setVirtualHost("/");
        Connection con = null;
        try {
            con = connectionFactory.newConnection();
            Channel cha = con.createChannel();
            return cha;
        } catch (Exception e) {
            logger.info(e, new Supplier<String>() {
                @Override
                public String get() {
                    return e.getMessage();
                }
            });
        }
        return null;
    }
}
