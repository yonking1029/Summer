package com.oil.services;

import java.util.List;

import com.oil.comm.mongo.User;

/**
 * 
 * TODO  Mongo用户业务接口.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:06:51<br>
 * @see 
 * @since JDK 1.7.0
 */
public interface MongoUserService {

	User findByName(String name);

	User findByNameAndAge(String name, Integer age);

    User findUser(String name);

    User findUserById(Long id);

	List<User> findAll();

	User save(User user);

	Long delete(Long id);

}
