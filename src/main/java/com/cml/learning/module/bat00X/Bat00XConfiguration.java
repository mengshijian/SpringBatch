package com.cml.learning.module.bat00X;

import com.cml.learning.module.bat00X.beans.Person;
import com.cml.learning.module.bat00X.listener.JobCompletionNotificationListener;
import com.cml.learning.module.bat00X.processor.PersonItemProcessor;
import com.cml.learning.module.bat00X.reader.PersonReader;
import com.cml.learning.module.bat00X.writer.PersonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Bat00XConfiguration {

	private static final Logger log = LoggerFactory.getLogger(Bat00XConfiguration.class);

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private PersonWriter personWriter;

	@Bean
	@Scope("prototype")
	public ItemReader<Person> reader() {
		return new PersonReader();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob1").incrementer(new RunIdIncrementer()).listener(listener).flow(step1()).end().build();
	}

	@Bean
	public Job secondJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob2").incrementer(new RunIdIncrementer()).listener(listener).flow(step2()).end().build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2").<Person, Person> chunk(2).reader(reader()).processor(processor()).writer(personWriter).build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person> chunk(2).reader(reader()).processor(processor()).writer(personWriter).build();
	}
	// end::jobstep[]
}