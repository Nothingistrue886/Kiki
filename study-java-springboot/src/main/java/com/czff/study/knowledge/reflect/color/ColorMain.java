package com.czff.study.knowledge.reflect.color;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuidi
 * @date 2021/4/14 10:42
 * @description 将属性为null的置为空串
 */
public class ColorMain {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Color color = new Color();
        List<Red> redList = new ArrayList<Red>();
        Red red = new Red();
        red.setName("red");
        redList.add(red);
        color.setRedList(redList);
        Class<? extends Color> colorClass = color.getClass();
        Method[] declaredMethods = colorClass.getDeclaredMethods();
        ArrayList<Method> getMethodList = new ArrayList<>();
        ArrayList<Method> setMethodList = new ArrayList<>();
        for (Method method : declaredMethods) {
            String name = method.getName();
            if (name.startsWith("get") && (!name.contains("listarrayconversion"))) {
                getMethodList.add(method);
            }
            if (name.startsWith("set") && (!name.contains("listarrayconversion"))) {
                setMethodList.add(method);
            }
        }
        for (Method getMethod : getMethodList) {
            String getMethodName = getMethod.getName();
            String str = (String) getMethod.invoke(color);
            if (str == null) {
                for (Method setMethod : setMethodList) {
                    String setMethodName = setMethod.getName();
                    String replaceFirstGetMethodName = getMethodName.replaceFirst("g", "s");
                    if (setMethodName.equals(replaceFirstGetMethodName)) {
                        setMethod.invoke(color, "green");
                    }
                }
            }
        }
        String name = color.getName();
        System.out.println("111" + name + "222");
    }
}
