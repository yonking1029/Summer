package com.oil.services;

/**
 * 
 * TODO 在此写上类的相关说明.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月28日 下午6:22:21<br>
 * @see 
 * @since JDK 1.7.0
 */
public interface JdbcTemplateUserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     * @return 
     */
    Integer create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();


}
