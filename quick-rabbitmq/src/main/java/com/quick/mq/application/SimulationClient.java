package com.quick.mq.application;

import com.quick.mq.util.RabbitUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/6/14
 * Time: 19:38
 * Description:
 */
public class SimulationClient {

    public static void main(String[] args) {
        try {
            Channel channel = RabbitUtil.getRabbitMqConfig();
            channel.queueDeclare("hello", false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", "hello", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            channel.getConnection().close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
