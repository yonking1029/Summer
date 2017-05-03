package com.oil.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.oil.dao.entitys.User;
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {
	@Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);
    
	@Results({
	  @Result(property = "createTime", column = "create_time"),
	  @Result(property = "updateTime", column = "update_time")
	})
	@Cacheable(key = "#p0", condition = "#p0 > 0") //id>0才会被缓存 缓存配置see ehcache.xml
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Long id);
//    @Results({
//        @Result(property = "name", column = "name"),
//        @Result(property = "age", column = "age")
//    })
    @Select("SELECT * FROM user")
    List<User> findAll();
    
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
    
    @Insert("INSERT INTO user(name, age, height) VALUES(#{user.name}, #{user.age}, #{user.height})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    int save(@Param("user") User user);
    
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);
    
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
    
    /**
     * userMapper.xml
     * @author leejean <br>
     * @Date 2017年5月3日 下午3:24:59<br>
     * @param user
     * @return
     */
    List<User> findByParams(User user);
}

