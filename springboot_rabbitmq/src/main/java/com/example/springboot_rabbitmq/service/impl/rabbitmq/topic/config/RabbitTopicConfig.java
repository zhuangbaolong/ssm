package com.example.springboot_rabbitmq.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    //队列
    @Bean
    public Queue topicQueue(){
        /**
         * durable:是否持久化，默认false
         * exclusive:是否当前连接自用,默认false，连接关闭队列关闭
         * autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除
         */
        return new Queue("topic_queue",true,false,false);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }
    //直连交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    //绑定
    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }
    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic2");
    }
}
