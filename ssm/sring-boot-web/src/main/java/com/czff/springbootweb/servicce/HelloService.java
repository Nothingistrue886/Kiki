package com.czff.springbootweb.servicce;

import org.springframework.stereotype.Service;

/**
 * @author 疾风劲草
 * @date 2020/12/23 21:46
 * @description
 */
@Service
public class HelloService {
    public String getName(String name){
        return name;
    }
}
