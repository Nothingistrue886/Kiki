package com.drools.test;

import com.drools.entity.ComparisonOperator;
import com.drools.entity.Order;
import com.drools.entity.Student;
import com.drools.service.UserService;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuidi
 * @description
 * @date 2023/6/29 10:49
 */
public class DroolsTest {

    @Test
    public void testOrder() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        //会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession();

        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Order order = new Order();
        order.setOriginalPrice(2d);

        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配 (工作内存)
        kieSession.insert(order);

        //激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();

        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }


    @Test
    public void testComparator() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        ComparisonOperator comparisonOperator = new ComparisonOperator();
        comparisonOperator.setNames("张三");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        comparisonOperator.setList(list);
        kieSession.insert(comparisonOperator);
        // 指定要执行的规则
//        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("member"));
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testUpdateStudent() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        Student student = new Student();
        student.setAge(5);
        kieSession.insert(student);
        // 指定要执行的规则
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testInsertStudent() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        Student student = new Student();
        student.setAge(10);
        kieSession.insert(student);
        // 指定要执行的规则
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testRetractStudent() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        Student student = new Student();
        student.setAge(10);
        kieSession.insert(student);
        // 指定要执行的规则
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testTimer() throws InterruptedException {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        final KieSession kieSession = kieClasspathContainer.newKieSession();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //启动规则引擎进行规则匹配，直到调用halt方法才结束规则引擎
                kieSession.fireUntilHalt();
            }
        }).start();
        Thread.sleep(10000);
        //结束规则引擎
        kieSession.halt();
        kieSession.dispose();
    }

    @Test
    public void testDate() {
        //设置日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testGlobal() {
        //设置日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        //设置全局变量，名称和类型必须和规则文件中定义的全局变量名称对应
        kieSession.setGlobal("userService", new UserService());
        kieSession.setGlobal("count", 5);
        Map<String, Object> map = new HashMap<>();
        kieSession.setGlobal("gMap", map);
        List<String> list = new ArrayList<>();//size为0
        kieSession.setGlobal("gList", list);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_global"));
        kieSession.dispose();

        //因为在规则中为全局变量添加了两个元素，所以现在的size为2
        System.out.println("gList的size：" + list.size());
        map.forEach((key, value) -> System.out.println(key + "--" + value));
    }

    @Test
    public void testQuery() {
        //设置日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();

        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge(12);

        Student student2 = new Student();
        student2.setName("李四");
        student2.setAge(8);

        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge(22);

        //将对象插入Working Memory中
        kieSession.insert(student1);
        kieSession.insert(student2);
        kieSession.insert(student3);

        //调用规则文件中的查询
        QueryResults results1 = kieSession.getQueryResults("query_1");
        int size = results1.size();
        System.out.println("size=" + size);
        for (QueryResultsRow row : results1) {
            Student student = (Student) row.get("$student");
            System.out.println(student);
        }

        //调用规则文件中的查询
        QueryResults results2 = kieSession.getQueryResults("query_2", "王五");
        size = results2.size();
        System.out.println("size=" + size);
        for (QueryResultsRow row : results2) {
            Student student = (Student) row.get("$student");
            System.out.println(student);
        }
        // query只是查询工作内存中符合的Fact，而不用激活所有规则
//        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void testFunction() {
        //设置日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession();
        Student student = new Student();
        student.setName("小明");
        kieSession.insert(student);
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_function_1"));
        kieSession.dispose();
    }
}
