package com.msj.batch.framework.constant;

public interface ModuleConst {
	interface Framwwork {
		/**
		 * 读写property配置
		 */
		String DB_CONFIG_RW = "classpath:config/jdbc-rw.properties";

		/**
		 * framework基础配置包
		 */
		String PACKAGE_FRAMEWORK = "com.msj.batch.framework";
		/**
		 * batch基础包名
		 */
		String PACKAGE_BATCH = "com.msj.batch";
		/**
		 * 读写mapper interface所在包配置
		 */
		String MAPPER_SCAN_RW_PACKAGE = "com.msj.batch.module";

		/**
		 * 定时任务目录
		 */
		String JOB_BASE_PACKAGE = "com.msj.batch.framework.schedled";

	}

	interface Module {
		/**
		 * batch 指定properties位置key
		 */
		String BATCH_PROPERTIES = "batchProperties";
		String BATCH_PROPERTIES_PLACEHOLDER = "${batchProperties}";
		String BATCH_PROPERTIES_FORMAT = "classpath:config/module/%s.properties";
	}
}
