package com.company.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



/**
 * @author czff
 */
@Component // 将组件交给spring管理默认名称: dataSourceBean
@Lazy
@Scope
public class DataSourceBean {

}
