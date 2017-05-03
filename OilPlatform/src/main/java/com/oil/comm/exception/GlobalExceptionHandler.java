package com.oil.comm.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oil.comm.dto.ReturnDTO;
import com.oil.comm.enums.ErrorCode;
import com.oil.comm.enums.ReturnStatusEnum;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        e.printStackTrace();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ReturnDTO jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
    	ReturnDTO returnDTO = new ReturnDTO();
    	returnDTO.setStatus(ReturnStatusEnum.FAIL.getValue());
    	returnDTO.setMsg(e.getMessage());
    	returnDTO.setData(req.getRequestURL().toString());
    	returnDTO.setErrorCode(ErrorCode.Error.getCode());
        if(null!=e.getCause()){
        	returnDTO.setErrorMsg(e.getCause().getMessage());
        }
        return returnDTO;
    }

}

