package com.czff.mydemo.zhonglvsmUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetsUser  {

    /**
     * 员工编号
     */
    private String code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门
     */
    private String depId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 座机号
     */
    private String landline;

    /**
     * 职位
     */
    private String job;


    public AssetsUser() {
    }

    public AssetsUser(String code, String name, String depId, String landline, String email, String job) {
        this.code = code;
        this.name = name;
        this.depId = depId;
        this.landline = landline;
        this.email = email;
        this.job = job;
    }
}
