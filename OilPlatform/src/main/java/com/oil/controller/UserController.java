package com.oil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oil.comm.dto.PageDTO;
import com.oil.comm.dto.ReturnDTO;
import com.oil.dao.entitys.User;
import com.oil.models.UserVo;
import com.oil.services.UserService;

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
@RequestMapping(value="/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value= "getUserList", method=RequestMethod.GET)
    public ReturnDTO getUserList() {
    	List<UserVo> userVos= userService.findAll();
        return ReturnDTO.Success(userVos);
    }
    @ApiOperation(value="获取用户列表ByParams", notes="获取用户列表ByParams")
    @RequestMapping(value= "findByParams", method=RequestMethod.POST)
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserVo")
    public ReturnDTO findByParams(@RequestBody UserVo user) {
    	List<UserVo> userVos= userService.findByParams(user);
    	return ReturnDTO.Success(userVos);
    }
    @ApiOperation(value="获取用户列表ByPage", notes="获取用户列表ByParams")
    @RequestMapping(value= "findUserByPage", method={RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pagesize", value = "页大小", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "user", value = "用户详细实体user", dataType = "UserVo")
    })
    public ReturnDTO findUserByPage(@RequestParam Integer page,@RequestParam Integer pagesize,@RequestBody UserVo user) {
    	PageDTO<User> pageDTO = userService.findUserByPage(page, pagesize, user);
    	return ReturnDTO.Success(pageDTO.toSimplePageDTO());
    }
//    @ApiOperation(value="获取用户列表", notes="获取用户列表")
//    @RequestMapping(value= "list", method=RequestMethod.GET)
//    public ReturnDTO list() {
//    	return ReturnDTO.Success(userService.list());
//    }

    @ApiOperation(value="创建用户", notes="根据UserVo对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserVo")
    @RequestMapping(value="addUser", method=RequestMethod.POST)
    public ReturnDTO addUser(@RequestBody UserVo user) {
        return ReturnDTO.Success(userService.save(user));
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "query")
    @RequestMapping(value="/getUser", method=RequestMethod.GET)
    public ReturnDTO getUser(@RequestParam Long id) {
        return ReturnDTO.Success(userService.findUserById(id));
    }

    @ApiOperation(value="更新用户详细信息", notes="并根据传过来的UserVo信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserVo")
    })
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public ReturnDTO editUser(@RequestBody UserVo user) {
        return ReturnDTO.Success(userService.save(user));
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/deleteUser/{id}", method=RequestMethod.POST)
    public ReturnDTO deleteUser(@PathVariable Long id) {
        return ReturnDTO.Success(userService.delete(id));
    }

}