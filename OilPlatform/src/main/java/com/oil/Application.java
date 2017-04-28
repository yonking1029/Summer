package com.oil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * TODO 程序启动类.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年3月28日 下午4:19:50<br>
 * @see 
 * @since JDK 1.7.0
 */
@SpringBootApplication
@EnableCaching //启用缓存
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
