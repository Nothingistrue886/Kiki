package com.czff.study.designmodel.strategy;

/**
 * @author 疾风劲草
 * @date 2023/11/30 15:56
 * @description 客户端
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        Context context = null;
        String action = "addition";
        if ("addition".equals(action)) {
             context = new Context(new OperationAdd());
        }
        if ("subtraction".equals(action)) {
            context = new Context(new OperationSubtract());
        }
        if ("multiplication".equals(action)) {
            context = new Context(new OperationMultiply());
        }
        int result = context.excuteOperation(1, 2);
        System.out.println(result);
    }
}
