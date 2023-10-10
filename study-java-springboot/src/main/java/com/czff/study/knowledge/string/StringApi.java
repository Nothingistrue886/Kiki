package com.czff.mydemo.knowledge.string;

/**
 * @author 疾风劲草
 * @date 2022/6/9 15:07
 * @description string api的使用
 */
public class StringApi {
    public static void main(String[] args) {

        // 替换空格和/
//        String str = " f d////a/ /fda";
//        String str = "Hq Wax Kex / Chxn Ix Lix";
//        String str2 = str.replaceAll("\\s|\\/+", "");
//        System.out.println(str2);
//        String str3 = str.replaceAll("\\D", "N");
//        System.out.println(str3);




        String string = "aaa456ac";
        //查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        System.out.println(string.indexOf("b")); // indexOf(String str); 返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(string.indexOf("a",3));//indexOf(String str, int fromIndex); 返回结果：6

        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99

        // 从头开始查找是否存在指定的字符
        System.out.println(string.indexOf(99));//indexOf(int ch)；返回结果：7
        System.out.println(string.indexOf('c'));//indexOf(int ch)；返回结果：7

        //从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
        System.out.println(string.indexOf(97,3));//indexOf(int ch, int fromIndex); 返回结果：6
        System.out.println(string.indexOf('a',3));//indexOf(int ch, int fromIndex); 返回结果：6
    }
}
