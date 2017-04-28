package com.oil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oil.comm.mongo.MongoDBUserRepository;
import com.oil.comm.mongo.User;

/**
 * 
 * TODO 用户业务实现类.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:26:24<br>
 * @see 
 * @since JDK 1.7.0
 */
@Service
public class MongoUserServiceImpl implements MongoUserService {

    @Autowired
    private MongoDBUserRepository mongoDBUserRepository;
	@Override
	public User findByName(String name) {
		return this.mongoDBUserRepository.findByName(name);
	}

	@Override
	public User findByNameAndAge(String name, Integer age) {
		return null;
	}

	@Override
	public User findUser(String name) {
		return this.mongoDBUserRepository.findByName(name);
	}
	@Override
	public User findUserById(Long id) {
		return this.mongoDBUserRepository.findOne(id);
	}
	@Override
	public List<User> findAll() {
		return this.mongoDBUserRepository.findAll();
	}
	@Override
	public User save(User user) {
		return this.mongoDBUserRepository.save(user);
	}
	@Override
	public Long delete(Long id) {
		this.mongoDBUserRepository.delete(id);
		return id;
	}
    
}
