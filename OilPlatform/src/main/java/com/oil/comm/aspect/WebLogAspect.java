package com.oil.comm.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.oil.comm.configs.SystemConfigs;
import com.oil.comm.utils.FormatUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Web层日志切面.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午6:28:10<br>
 * @see 
 * @since JDK 1.7.0
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect {

	@Autowired
	private SystemConfigs systemConfigs;
	
    private Logger logger = Logger.getLogger(getClass());
    
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.oil.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if(systemConfigs.getShow_request_params()){
            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("方法 : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("类方法 : "  + joinPoint.getSignature().getDeclaringTypeName() + "." 
            					  + joinPoint.getSignature().getName());
            logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        }
        
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
    	if(systemConfigs.getShow_response_datas()){
    		// 处理完请求，返回内容
    		if(systemConfigs.getResponse_data_format()){
    			logger.info("响应 : \n"+FormatUtil.getJsonFormatString(ret));
    		}else{
    			logger.info("响应 : " + ret);
    		}
    		logger.info("耗时 : " + (System.currentTimeMillis() - startTime.get()) +" ms");
    	}
    }

}

