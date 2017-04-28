package com.oil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oil.comm.exception.MyException;

/**
 * 
 * TODO 在此写上类的相关说明.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午6:07:42<br>
 * @see 
 * @since JDK 1.7.0
 */
@Controller
@RequestMapping("/exception")
public class ExceptionTestController {
//	http://127.0.0.1:8080/exception/t1
    @RequestMapping("/t1")
    public String t1() throws Exception {
        throw new Exception("发生错误");
    }
//    http://127.0.0.1:8080/t1
    @RequestMapping("/t2")
    public String t2() throws MyException {
        throw new MyException("发生错误");
    }
//   http://127.0.0.1:8080/t3
    @RequestMapping("/t3")
    public String t3() throws MyException {
        throw new MyException("发生错误",new Exception("错误内容"));
    }
//    http://127.0.0.1:8080/
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "...");
        return "index";
    }

}