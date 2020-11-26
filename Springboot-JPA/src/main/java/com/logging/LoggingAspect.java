package com.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.controller.StudentController.getAllStudent())")
	public void logBefore()
	{
		LOGGER.info("getAllStudent Called");
	}
	
	@After("execution(public * com.controller.StudentController.getAllStudent())")
	public void logAfter()
	{
		LOGGER.info("getAllStudent Executed");
	}
	
	/* 
	 * @After - default finally
	 * @AfterReturning - it is work when method successfully executed
	 * @AfterThrowing - it is work when you get exception 
	 */
}
