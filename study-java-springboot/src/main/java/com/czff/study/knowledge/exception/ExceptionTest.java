package com.czff.study.knowledge.exception;

/**
 * @author cuidi
 * @date 2020/12/9 9:47
 * @description 方法上抛异常          是为了让调用者知道这个方法可能会抛这个异常  必须做处理
 *              方法体里抛这个异常    是因为代码可能会出现异常                   抛一个运行时异常
 */
public class ExceptionTest {

    public static void main(String[] args) {

        try {
            int z = 5 / 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new ArithmeticException("参数异常");
        }
    }

}
