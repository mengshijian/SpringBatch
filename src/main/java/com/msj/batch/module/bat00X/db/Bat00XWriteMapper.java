package com.msj.batch.module.bat00X.db;

import com.msj.batch.framework.mybatis.marker.WriteMapper;
import com.msj.batch.module.bat00X.beans.LogBean;

public interface Bat00XWriteMapper extends WriteMapper {
	void insertLog(LogBean logbean);
}
