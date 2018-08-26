package com.cml.learning.framework.schedled;

import com.cml.learning.framework.annotation.JobInfo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@JobInfo(group = "job",name = "JobTask",cronExp = "0/2 * * * * ? ")
public class JobTask1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("JobTask1");
    }
}
