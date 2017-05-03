package com.oil.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.oil.dao.entitys.User;
import com.oil.dao.mappers.UserMapper;
import com.oil.models.UserVo;

/**
 * 
 * TODO 用户业务实现类.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:26:24<br>
 * @see 
 * @since JDK 1.7.0
 */
@Service
public class UserServiceImpl implements UserService {
	private Logger logger =  Logger.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

	@Override
	public UserVo findByName(String name) {
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(this.userMapper.findByName(name), userVo);
		return userVo;
	}
	@Override
	public UserVo findUserById(Long id) {
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(this.userMapper.findById(id), userVo);
		return userVo;
	}

	@Override
	public List<UserVo> findAll() {
		List<User> findAll = this.userMapper.findAll();
		UserVo userVo = null;
		List<UserVo> userVos = Lists.newArrayList();
		for (User user : findAll) {
			userVo = new UserVo();
			BeanUtils.copyProperties(user, userVo);
			userVos.add(userVo);
		}
		return userVos;
	}
//	@Transactional
//	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public UserVo save(UserVo userVo) {
		User user = new User();
		
		BeanUtils.copyProperties(userVo, user);
		
		this.userMapper.save(user);
				
		return this.findUserById(user.getId());
	}

	@Override
	public Long delete(Long id) {
		this.userMapper.delete(id);
		return id;
	}

	@Override
	public void testTransaction() {
		this.save(new UserVo("name1", 16, 175.5));
		this.save(new UserVo("我就是要测试一下我如果输入的名字很长，下面那条数据会不会保存成功", 16, 175.5));
		this.save(new UserVo("name2", 15, 180.00));
	}
	@Override
	public List<UserVo> findByParams(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		logger.info(JSON.toJSONString(user));
		List<User> findAll = userMapper.findByParams(user);
		List<UserVo> userVos = Lists.newArrayList();
		for (User user2 : findAll) {
			userVo = new UserVo();
			BeanUtils.copyProperties(user2, userVo);
			userVos.add(userVo);
		}
		return userVos;
	}

//	@Override
//	public List list() {
//		// TODO Auto-generated method stub
//		return userJpaRepository.listBySQL("from t_user");
//		
//	}
    
}
