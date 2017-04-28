package com.oil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.oil.services.JdbcTemplateUserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class JdbcTemplateTests {

	@Autowired
	private JdbcTemplateUserService jdbcTemplateUserService;

	@Before
	public void setUp() {
		//userRepository.deleteAll();
	}

	@Test
	public void getAllUsers() throws Exception {
		try {
			Integer allUsers = jdbcTemplateUserService.getAllUsers();
			System.out.println(allUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void create() throws Exception {
		try {
			Integer create = jdbcTemplateUserService.create("小小舒", 16);
			System.out.println(create);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}