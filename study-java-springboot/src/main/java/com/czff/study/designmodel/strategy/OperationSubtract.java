package com.czff.study.designmodel.strategy;

/**
 * @author 疾风劲草
 * @date 2023/11/30 15:53
 * @description
 */
public class OperationSubtract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}