package com.cml.learning.framework.configuration;

import com.cml.learning.framework.annotation.JobInfo;
import com.cml.learning.framework.constant.ModuleConst;
import com.cml.learning.framework.constant.ModuleConst.Framwwork;
import com.cml.learning.framework.schedled.JobTask;
import com.cml.learning.framework.util.ClassUtils;
import java.util.Set;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.quartz.Scheduler;

@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtils.class);

    @Autowired
    private Scheduler scheduled;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            Set<Class<?>> jobs = ClassUtils.getClassSet(Framwwork.JOB_BASE_PACKAGE,Job.class);
            for (Class<?> cla : jobs){
                JobInfo info = cla.getAnnotation(JobInfo.class);
                if (info != null){
                    String group = info.group();
                    JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) cla).withIdentity(info.name(), info.group()).build();
                    // 基于表达式构建触发器
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(info.cronExp());
                    // CronTrigger表达式触发器 继承于Trigger
                    // TriggerBuilder 用于构建触发器实例
                    CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(info.name(), info.group())
                        .withSchedule(cronScheduleBuilder).build();
                    scheduled.scheduleJob(jobDetail, cronTrigger);
                }
            }
        } catch (SchedulerException e) {
            LOGGER.error("定时器初始化异常",e);
        }
    }
}
