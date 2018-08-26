package com.cml.learning.framework.schedled;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.quartz.Scheduler;

@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Scheduler scheduled;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        JobDetail jobDetail = JobBuilder.newJob(JobTask.class).withIdentity("job1", "group1").build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1")
                .withSchedule(cronScheduleBuilder).build();

        JobDetail jobDetail1 = JobBuilder.newJob(JobTask1.class).withIdentity("job2", "group1").build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder1 = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger1 = TriggerBuilder.newTrigger().withIdentity("job2", "group1")
                .withSchedule(cronScheduleBuilder).build();
        try {
            scheduled.scheduleJob(jobDetail, cronTrigger);
            scheduled.scheduleJob(jobDetail1, cronTrigger1);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
