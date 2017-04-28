package com.oil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oil.comm.mongo.User;
import com.oil.services.MongoUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * TODO 用户类控制器.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午1:51:07<br>
 * @see 
 * @since JDK 1.7.0
 */
@RestController
@RequestMapping(value="/mongoUser")
public class MongoUserController {

	@Autowired
	private MongoUserService mongoUserService;
	
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value= "getUserList", method=RequestMethod.GET)
    public List<User> getUserList() {
        return mongoUserService.findAll();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="addUser", method=RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return mongoUserService.save(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "query")
    @RequestMapping(value="/getUser", method=RequestMethod.GET)
    public User getUser(@RequestParam Long id) {
        return mongoUserService.findUserById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public User editUser(@RequestBody User user) {
        return mongoUserService.save(user);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/deleteUser/{id}", method=RequestMethod.POST)
    public Long deleteUser(@PathVariable Long id) {
        return mongoUserService.delete(id);
    }

}
