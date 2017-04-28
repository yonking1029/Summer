package com.oil;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oil.comm.mongo.MongoDBUserRepository;
import com.oil.comm.mongo.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MongoDBTests {

	@Autowired
	private MongoDBUserRepository mongoDBUserRepository;

	@Before
	public void setUp() {
		//userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		try {
			// 创建三个User，并验证User总数
			mongoDBUserRepository.save(new User(1L, "嘿嘿嘿1", 30));
			mongoDBUserRepository.save(new User(2L, "嘿嘿嘿2", 40));
			mongoDBUserRepository.save(new User(3L, "嘿嘿嘿3", 50));
			List<User> findAll = mongoDBUserRepository.findAll();
			for (User user : findAll) {
				System.out.println(user.toString());
			}
//		// 删除一个User，再验证User总数
//		User u = userRepository.findOne(1L);
//		userRepository.delete(u);
//		Assert.assertEquals(2, userRepository.findAll().size());
//
//		// 删除一个User，再验证User总数
//		u = userRepository.findByUsername("mama");
//		userRepository.delete(u);
//		Assert.assertEquals(1, userRepository.findAll().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
