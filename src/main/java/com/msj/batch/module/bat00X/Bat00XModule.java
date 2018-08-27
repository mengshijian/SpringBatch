package com.msj.batch.module.bat00X;

import com.msj.batch.framework.annotation.BatchAnnotation;
import com.msj.batch.framework.constant.ModuleConst;
import com.msj.batch.framework.module.BaseModule;

@BatchAnnotation
public class Bat00XModule extends BaseModule implements ModuleConst {

	public static final String MODULE_NAME = "bat00X";

	public static final String KEY_OPERATE_COUNT = "operateCount";

	/**
	 * 测试batch，用户配置基础batch module信息
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		run(Bat00XModule.class,MODULE_NAME, args);
	}

}