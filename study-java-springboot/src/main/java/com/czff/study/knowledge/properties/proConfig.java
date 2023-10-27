package com.czff.study.knowledge.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author cuidi
 * @date 2021/10/20 17:31
 * @description 操作属性文件类
 */
public class proConfig {

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        // 将路径表达式修改为：“czff-study\src\main\resources\fruit.properties”
        // (PS: 如果将路径表达式修改为"\\czff-study\src\main\resources\fruit.properties"，也会报错）
        File file = new File("czff-study\\src\\main\\resources\\fruit.properties");
        if (file.exists()) {
            properties.load(new FileInputStream(file));
        } else {
            properties.setProperty("apple", "com.czff.study.knowledge.properties.Apple");
            properties.setProperty("orange", "com.czff.study.knowledge.properties.Orange");
            properties.store(new FileOutputStream(file), "FRUIT CLASS");
        }
        return properties;
    }

}
