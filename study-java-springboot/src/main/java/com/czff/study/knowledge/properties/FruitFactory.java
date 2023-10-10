package com.czff.mydemo.knowledge.properties;

/**
 * @author cuidi
 * @date 2021/10/20 17:05
 * @description 水果工厂
 */
public class FruitFactory {

    public static Fruit getInstance(String fruitName) {
        Fruit fruit = null;
//        if("Apple".equalsIgnoreCase(fruitName)){
//            fruit = new Apple();
//        }
//        if("Orange".equalsIgnoreCase(fruitName)){
//            fruit = new Orange();
//        }
        try {
            Class<?> cls = Class.forName(fruitName);
            fruit = (Fruit) cls.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
