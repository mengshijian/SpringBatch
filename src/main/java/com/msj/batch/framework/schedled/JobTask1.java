package com.msj.batch.framework.schedled;

import com.msj.batch.framework.annotation.JobInfo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@JobInfo(group = "job",name = "JobTask1",cronExp = "0/2 * * * * ? ")
public class JobTask1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("JobTask1");
    }
}
