package com.czff.springbootweb.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2021/2/1 21:51
 * @description 给容器中加入自定义的 ErrorAttributes
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    /**
     * 返回值 map 中所包含的数据就是页面和 json 能获取的字段
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("sign", "less is more");
        Map<String, Object> requestAttribute = (Map<String, Object>) webRequest.getAttribute("other", 0);
        map.put("attribute", requestAttribute);
        return map;
    }


}
