package com.yangtzelsl.websocket.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

import static com.yangtzelsl.websocket.server.WebSocketServer.sendMessage;

/**
 * @Description: SocketConsumer
 * @Author luis.liu
 * @Date: 2021/5/27 20:39
 * @Version 1.0
 */
@Slf4j
public class SocketConsumer extends Thread {

    @Override
    public void run() {
        Properties prop = new Properties();
        System.out.println("启动kafka消费者....");
        log.info("启动kafka消费者....");
        prop.put("bootstrap.servers", "127.0.0.1:9092");
        prop.put("group.id", "socket_test_lsl");
        prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        Consumer consumer = new KafkaConsumer(prop);
        consumer.subscribe(Arrays.asList("event_topic"));
        while (true) {
            ConsumerRecords<String, String> c = consumer.poll(100);
            for (ConsumerRecord<String, String> c1 : c) {
                System.out.println(c1.value());
                log.info(c1.value());
                sendMessage("socket", c1.value());
            }
        }
    }
}
