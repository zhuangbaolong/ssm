package com.example.springboot_rabbitmq.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//queue直连配置
public class RabbitDirectConfig {
    //队列
    @Bean
    public Queue directQueue(){
        /**
         * durable:是否持久化，默认false
         * exclusive:是否当前连接自用,默认false，连接关闭队列关闭
         * autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除
         */
        return new Queue("direct_queue",true,false,false);
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct_queue2");
    }
    //直连交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    //绑定
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }
    @Bean
    public Binding bindingDirect2(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct2");
    }
}
