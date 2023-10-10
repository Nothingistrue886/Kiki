package com.czff.mydemo.knowledge.reflect.methodinvoke;

import java.lang.reflect.InvocationTargetException;

/**
 * @author cuidi
 * @date 2020/11/4 17:37
 * @description
 */
public class Method {
    public static void main(String[] args) {
        methodInvoke();
    }

    private static void methodInvoke() {
        String[] names = new String[]{"cuidi", "tangmu", "fdafa"};
        Class<?> cls = SayHello.class;
        try {
            Object instance = cls.newInstance();
            // 传入的第一个参数是方法名，第二个参数名是方法参数类型，
            // 传入这两个参数之后，便可以根据方法名和方法参数类型通过反射获取带有参数的方法
            java.lang.reflect.Method method = cls.getDeclaredMethod("sayHello", String.class);
            method.setAccessible(true);
            for (String name : names) {
                method.invoke(instance, name);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}

