package com.example.springboot_task.config;

import com.example.springboot_task.quartz.MYQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    //工作明细
    @Bean
    public JobDetail printJobDetail(){
        //绑定具体的工作
        return JobBuilder
                .newJob(MYQuartz.class)
                .storeDurably()
                .build();
    }
    //触发器,绑定对应的工作明细
    @Bean
    public Trigger printJobTrigger(){
        ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");//任意秒每10秒几分几时 几日几月的星期？
        return TriggerBuilder
                .newTrigger()
                .forJob(printJobDetail())
                .withSchedule(schedBuilder)
                .build();
    }
}
