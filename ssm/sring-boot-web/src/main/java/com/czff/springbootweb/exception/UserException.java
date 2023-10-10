package com.czff.springbootweb.exception;

/**
 * @author 疾风劲草
 * @date 2021/1/31 20:58
 * @description
 */
public class UserException  extends RuntimeException{

    public UserException(){
        super("用户不存在");
    }
}
