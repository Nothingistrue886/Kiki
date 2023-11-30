package com.czff.study.designmodel.strategy;

/**
 * @author 疾风劲草
 * @date 2023/11/30 15:54
 * @description
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int excuteOperation(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
