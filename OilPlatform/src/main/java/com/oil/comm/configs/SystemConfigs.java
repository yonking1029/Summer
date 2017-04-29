package com.oil.comm.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * 系统参数定义<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月19日 下午4:42:48<br>
 * @see 
 * @since JDK 1.7.0
 */
@Component
public class SystemConfigs {
	/**
	 * 是否显示请求参数
	 */
    @Value("${configs.show_request_params}")
    public Boolean show_request_params = false;
    /**
     * 是否显示响应结果
     */
    @Value("${configs.show_response_datas}")
    public Boolean show_response_datas = false;
    
    /**
     * 是否显示响应结果
     */
    @Value("${configs.response_data_format}")
    public Boolean response_data_format = false;
    /**
     * 日志切面配置
     */
    @Value("${configs.aspect.pointcut}")
    public String aspect_pointcut = "";
    
	public Boolean getShow_request_params() {
		return show_request_params;
	}
	public void setShow_request_params(Boolean show_request_params) {
		this.show_request_params = show_request_params;
	}
	public Boolean getShow_response_datas() {
		return show_response_datas;
	}
	public void setShow_response_datas(Boolean show_response_datas) {
		this.show_response_datas = show_response_datas;
	}
	public String getAspect_pointcut() {
		return aspect_pointcut;
	}
	public void setAspect_pointcut(String aspect_pointcut) {
		this.aspect_pointcut = aspect_pointcut;
	}
	public Boolean getResponse_data_format() {
		return response_data_format;
	}
	public void setResponse_data_format(Boolean response_data_format) {
		this.response_data_format = response_data_format;
	}
	
}
