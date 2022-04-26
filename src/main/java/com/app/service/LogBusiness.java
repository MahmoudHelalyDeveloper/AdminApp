package com.app.service;

import com.app.entity.LogService;

public abstract class LogBusiness {

public	abstract LogService saveLogService(LogService logService);

public abstract int contLogingFalidForLogin(String userName);
	
}
