package com.czff.study.knowledge.jvm.classloader;

/**
 * @author cuidi
 * @date 2022/1/8 13:35
 * @description HelloWorld类写在记事本里，在用javac命令行编译成class文件，放在d盘根目录下
 */
public class ClassLoaderMain {

    public static void main(String[] args) throws Exception {
        String path = "D:\\HelloWorld.class";
        CustomClassLoader customClassLoader = new CustomClassLoader(path);
        String packagePath = "HelloWorld";
        //Class<?> clazz = customClassLoader.loadClass(packagePath);
        Class<?> clazz = Class.forName(packagePath, true, customClassLoader);
        Object instance = clazz.newInstance();
        System.out.println(instance.getClass().getClassLoader());
    }
}
