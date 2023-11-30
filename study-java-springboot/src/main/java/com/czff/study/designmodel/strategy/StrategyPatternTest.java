package com.czff.study.designmodel.strategy;

/**
 * @author 疾风劲草
 * @date 2023/11/30 15:56
 * @description
 */
public class StrategyPatternTest {
    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        int result = context.excuteOperation(1, 2);
        System.out.println(result);

    }
}
