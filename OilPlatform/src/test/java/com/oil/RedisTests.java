package com.oil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oil.entitys.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RedisTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		try {
			// 保存字符串
			stringRedisTemplate.opsForValue().set("12345", "redis数据库");
			Assert.assertEquals("redis数据库", stringRedisTemplate.opsForValue().get("12345"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
	@Test
	public void test2() throws Exception {
		
		try {
			// 保存对象
			User user = new User("超人", 20);
			redisTemplate.opsForValue().set(user.getName(), user);

			user = new User("蝙蝠侠", 30);
			redisTemplate.opsForValue().set(user.getName(), user);

			user = new User("蜘蛛侠", 40);
			redisTemplate.opsForValue().set(user.getName(), user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
