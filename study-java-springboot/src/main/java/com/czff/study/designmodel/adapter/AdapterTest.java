package com.czff.mydemo.designmodel.adapter;

import java.util.concurrent.Callable;

/**
 * @author cuidi
 * @date 2022/4/7 15:21
 * @description 适配器模式主要是为了接口的转换，而装饰者模式关注的是通过组合来动态的为被装饰者注入新的功能或行为(即所谓的责任)。
 *
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
 *
 *
 * 适配器模式在Java标准库中有广泛应用。比如我们持有数据类型是String[]，但是需要List接口时，可以用一个Adapter：
 *
 * String[] exist = new String[] {"Good", "morning", "Bob", "and", "Alice"};
 * Set<String> set = new HashSet<>(Arrays.asList(exist));
 * 注意到List<T> Arrays.asList(T[])就相当于一个转换器，它可以把数组转换为List。
 *
 * 我们再看一个例子：假设我们持有一个InputStream，希望调用readText(Reader)方法，但它的参数类型是Reader而不是InputStream，怎么办？
 * 当然是使用适配器，把InputStream“变成”Reader：
 * InputStream input = Files.newInputStream(Paths.get("/path/to/file"));
 * Reader reader = new InputStreamReader(input, "UTF-8");
 * readText(reader);
 * InputStreamReader就是Java标准库提供的Adapter，它负责把一个InputStream适配为Reader。类似的还有OutputStreamWriter。
 *
 * 如果我们把readText(Reader)方法参数从Reader改为FileReader，会有什么问题？这个时候，因为我们需要一个FileReader类型，就必须把InputStream适配为FileReader：
 * FileReader reader = new InputStreamReader(input, "UTF-8"); // compile error!
 * 直接使用InputStreamReader这个Adapter是不行的，因为它只能转换出Reader接口。
 * 事实上，要把InputStream转换为FileReader也不是不可能，但需要花费十倍以上的功夫。
 * 这时，面向抽象编程这一原则就体现出了威力：持有高层接口不但代码更灵活，而且把各种接口组合起来也更容易。一旦持有某个具体的子类类型，要想做一些改动就非常困难。
 */
public class AdapterTest {
    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
