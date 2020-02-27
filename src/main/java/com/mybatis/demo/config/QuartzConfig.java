package com.mybatis.demo.config;

import com.mybatis.demo.job.MyTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    // 指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(MyTask.class).withIdentity("MyTask").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail()).withIdentity("MyTask").withSchedule(scheduleBuilder).build();
    }
}
