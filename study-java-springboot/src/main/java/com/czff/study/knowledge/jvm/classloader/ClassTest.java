package com.czff.study.knowledge.jvm.classloader;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author cuidi
 * @date 2022/12/18 18:01
 * @description
 */
public class ClassTest {

    public static void main(String[] args) throws Exception {
        One oneObject = One.class.getDeclaredConstructor().newInstance();
        oneObject.call();

        Another anotherObject = Another.class.getDeclaredConstructor().newInstance();
        anotherObject.speak();

        Field field = One.class.getDeclaredField("inner");
        field.setAccessible(true);
        field.set(oneObject, "world changed");
        System.out.println(oneObject.getInner());
        System.out.println("<===================================================>");

        // 查看Bootstrap所有已加载的类库
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs(); // jdk1.8
        URLClassLoader bootstrapClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        URL[] urLs = bootstrapClassLoader.getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toString());
        }
        System.out.println("<===================================================>");

        // 查看本地类加载器
        ClassLoader classLoader = One.class.getClassLoader();
        ClassLoader extension = classLoader.getParent();
        ClassLoader root = extension.getParent();

        System.out.println(classLoader);
        System.out.println(extension);
        System.out.println(root.toString());

    }

    static class One {
        private String inner = "time files";

        public One() {}

        void call() {
            System.out.println("hello world!");
        }

        String getInner() {
            return inner;
        }
    }

    static class Another {

        public Another() {}

        void speak() {
            System.out.println("easy coding");
        }
    }
}

