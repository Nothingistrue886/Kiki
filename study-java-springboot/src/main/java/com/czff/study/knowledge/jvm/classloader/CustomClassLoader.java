package com.czff.mydemo.knowledge.jvm.classloader;

import java.io.*;

/**
 * @author cuidi
 * @date 2022/1/8 9:33
 * @description 自定义类加载器
 */
public class CustomClassLoader extends ClassLoader {
    /**
     * 字节码路径
     */
    private String classDir;

    public CustomClassLoader(String classDir) {
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 将class文件转化为字节码数组
            byte[] result = getClassFromCustomPath(classDir);
            if (result == null) {
                throw new FileNotFoundException();
            }
            // 将class的字节码数组转换成Class类的实例
            return defineClass(name, result, 0, result.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    public byte[] getClassFromCustomPath(String classDir) throws FileNotFoundException {
        File file = new File(classDir);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int size = 0;
            while ((size = in.read(buffer)) != -1) {
                out.write(buffer, 0, size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assert out != null;
        return out.toByteArray();
    }
}
