package com.oil.respository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oil.entitys.User;


/**
 * 
 * TODO 在此写上类的相关说明.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午1:42:43<br>
 * @see 
 * @since JDK 1.7.0
 */
@CacheConfig(cacheNames = "users")
public interface UserJpaRepository extends BaseRepository<User, Long> {
	/**
	 * 启用缓存，condition 第1个参数如果大于50，不加入缓存
	 * @author Leejean <br>
	 * @Date 2017年4月25日 下午4:32:45<br>
	 * @param name
	 * @param age
	 * @return
	 */
	@Cacheable(key = "#p0", condition = "#p0.length() < 10")
    User findByName(String name);
	
    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    
    @Query("from User u where u.id=:id")
    @Cacheable(key = "#p0", condition = "#p0 >0 ")
    User findUserById(@Param("id") Long id);

}
