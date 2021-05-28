package com.yangtzelsl.websocket.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: ConsumerLinster
 * @Author luis.liu
 * @Date: 2021/5/27 20:40
 * @Version 1.0
 */
@Slf4j
@Component
public class ConsumerLinster {
    public ConsumerLinster() {
        System.out.println("启用Kafka监听器");
        log.info("启用Kafka监听器");
        SocketConsumer socketConsumer = new SocketConsumer();
        socketConsumer.start();
        System.out.println("Kafka监听器启用成功");
        log.info("Kafka监听器启用成功");
    }
}
