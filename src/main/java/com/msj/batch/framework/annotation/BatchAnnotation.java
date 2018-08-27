package com.msj.batch.framework.annotation;

import com.msj.batch.framework.configuration.SimpleBatchConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.msj.batch.framework.constant.ModuleConst;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@EnableBatchProcessing
@Import({ SimpleBatchConfiguration.class })
@ComponentScan
@ComponentScans({ @ComponentScan(ModuleConst.Framwwork.PACKAGE_FRAMEWORK) })
@PropertySources({ @PropertySource(ModuleConst.Framwwork.DB_CONFIG_RW)})
@PropertySource(ModuleConst.Module.BATCH_PROPERTIES_PLACEHOLDER)
public @interface BatchAnnotation {

}
