package com.cml.learning.framework.schedled;

import com.cml.learning.framework.annotation.JobInfo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JobInfo(group = "job",name = "JobTask",cronExp = "0/5 * * * * ? ")
public class JobTask implements Job {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("JobTask");
    }
}
