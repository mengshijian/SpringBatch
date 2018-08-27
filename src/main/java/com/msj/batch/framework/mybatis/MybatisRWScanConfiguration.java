package com.msj.batch.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import com.msj.batch.framework.constant.ModuleConst;
import com.msj.batch.framework.mybatis.marker.WriteMapper;

@Configuration
@AutoConfigureAfter(MybatisRWConfig.class)
@MapperScan(markerInterface = WriteMapper.class, basePackages = { ModuleConst.Framwwork.MAPPER_SCAN_RW_PACKAGE}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisRWScanConfiguration {
	protected static Log log = LogFactory.getLog(MybatisRWScanConfiguration.class);

	public MybatisRWScanConfiguration() {
		log.info("*************************MybatisScanConfiguration***********************");
	}
}
