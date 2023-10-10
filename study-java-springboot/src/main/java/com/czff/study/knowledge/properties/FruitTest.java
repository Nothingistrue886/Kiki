package com.czff.mydemo.knowledge.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * @author cuidi
 * @date 2021/10/20 17:10
 * @description
 */
public class FruitTest {

    public static void main(String[] args) throws IOException {
        Properties pro = proConfig.getProperties();
        Fruit fruit = FruitFactory.getInstance(pro.getProperty("apple"));
        if (fruit != null) {
            fruit.eat();
        }
    }
}
