package com.company.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 疾风劲草
 * @date 2020/4/18 21:09
 */
@Service
public class SearchService {

    @Autowired
    @Qualifier("dataSourceBean") /* 假如DataSourceBean是一个接口并且有很多实现类需要指定名称 */
    private DataSourceBean bean;

    public String search(){
        return "search  ::::::::::::::  " + bean;
    }
}
