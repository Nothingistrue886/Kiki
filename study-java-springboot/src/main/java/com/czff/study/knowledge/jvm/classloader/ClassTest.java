package com.czff.mydemo.knowledge.jvm.classloader;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;

/**
 * @author cuidi
 * @date 2022/12/18 18:01
 * @description
 */
public class ClassTest {
    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> oneClass = One.class;
    private static Class<Another> anotherClass = Another.class;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        One oneObject = oneClass.newInstance();
        oneObject.call();

        Another anotherObject = anotherClass.newInstance();
        anotherObject.speak();

        Field field = oneClass.getDeclaredField("inner");
        field.setAccessible(true);
        field.set(oneObject, "world changed");
        System.out.println(oneObject.getInner());
        System.out.println("<===================================================>");

        // 查看Bootstrap所有已加载的类库
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toString());
        }
        System.out.println("<===================================================>");

        // 查看本地类加载器
        ClassLoader classLoader = oneClass.getClassLoader();
        ClassLoader extension = classLoader.getParent();
        ClassLoader root = extension.getParent();

        System.out.println(classLoader.toString());
        System.out.println(extension.toString());
        System.out.println(root.toString());

    }

    class One {
        private String inner = "time files";

        void call() {
            System.out.println("hello world!");
        }

        String getInner() {
            return inner;
        }
    }

    class Another {
        void speak() {
            System.out.println("easy coding");
        }
    }
}

