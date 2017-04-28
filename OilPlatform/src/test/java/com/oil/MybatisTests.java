package com.oil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oil.comm.mybatis.UserMapper;
import com.oil.entitys.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@Transactional
public class MybatisTests {

	@Autowired
	private UserMapper userMapper;

	@Test
//	@Rollback
	public void insert() throws Exception {
		int i = userMapper.insert("消消暑", 15);
		System.out.println(i);
	}
	@Test
//	@Rollback
	public void findByName() throws Exception {
		User u = userMapper.findByName("消消暑");
		System.out.println(u);
	}

}