package com.czff.spring.aop;

        import org.junit.Test;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 疾风劲草
 * @date 2021/4/11 21:17
 * @description TODO
 */

public class AspectTest {



    @Test
    public void aspect(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        Calculate bean = context.getBean(Calculate.class);
        bean.div(1, 0);
    }
}
