package com.czff.mydemo.zhonglvsmUtil;

import lombok.Data;

/**
 * @author cuidi
 * @description 竹云对接account(账号)
 * @date 2023/2/20 17:01
 */
@Data
public class BimAccountDTO {

    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 是否为必填字段
     */
    private boolean required;

    /**
     * 是否为多值
     */
    private boolean multivalued;


}
