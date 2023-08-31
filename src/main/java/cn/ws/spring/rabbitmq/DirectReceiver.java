package cn.ws.spring.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(byte[] msg) throws UnsupportedEncodingException {

        String res = new String(msg, "UTF-8");;
        System.out.println("DirectReceiver消费者收到消息  : " + res);
    }

}
