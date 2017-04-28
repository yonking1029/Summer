package com.oil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oil.entitys.User;
import com.oil.respository.UserJpaRepository;
import com.oil.services.JpaUserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class JpaTests {

	@Autowired
	private JpaUserService jpaUserService;
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private CacheManager cacheManager;

	@Before
	public void before() {
		//userJpaRepository.save(new User("AAA", 18));
	}
	@Test
	public void testTransaction() throws Exception {
		try {
			jpaUserService.testTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 测试一下缓存
	 * @EnableCaching //启用缓存
		public class Application {
	 */
	@Test
	public void testCache() throws Exception {
		try {
			//userRepository.save(new User("AAA", 10));
			System.out.println("--------------------------------------"+System.currentTimeMillis());
			User u1 = userJpaRepository.findByName("AAA");
			System.out.println("第一次查询：" + u1.getAge());
			System.out.println("--------------------------------------"+System.currentTimeMillis());
			User u2 = userJpaRepository.findByName("AAA");
			System.out.println("第二次查询：" + u2.getAge());
			System.out.println("--------------------------------------"+System.currentTimeMillis());
			u1.setAge(20);
			userJpaRepository.save(u1);
			User u3 = userJpaRepository.findByName("AAA");
			System.out.println("第三次查询：" + u3.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}

