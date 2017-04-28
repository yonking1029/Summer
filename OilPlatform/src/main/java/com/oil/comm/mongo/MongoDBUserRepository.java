package com.oil.comm.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * TODO mongoDB 测试 .<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月19日 下午3:43:01<br>
 * @see 
 * @since JDK 1.7.0
 */
public interface MongoDBUserRepository extends MongoRepository<User, Long> {

    User findByName(String username);

}
