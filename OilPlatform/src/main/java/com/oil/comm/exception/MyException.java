package com.oil.comm.exception;

/**
 * 
 * TODO 自定义异常.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:53:13<br>
 * @see 
 * @since JDK 1.7.0
 */
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
