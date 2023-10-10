package com.czff.mydemo.util.sensitiveutil;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * @author 疾风劲草
 * @date 2022/9/17 21:53
 * @description TODO
 */
public class SensitiveWordTest {

    public static void main(String[] args) {
        SensitiveWord sensitiveWord1 = new SensitiveWord();
        SensitiveWord sensitiveWord2 = new SensitiveWord();
        SensitiveWord sensitiveWord3 = new SensitiveWord();
        SensitiveWord sensitiveWord4 = new SensitiveWord();
        sensitiveWord1.setContent("阿扁推翻");
        sensitiveWord2.setContent("挨了一炮");
        sensitiveWord3.setContent("安街逆");
        sensitiveWord4.setContent("爱液横流");
        ArrayList<SensitiveWord> sensitiveWords = new ArrayList<>();
        sensitiveWords.add(sensitiveWord1);
        sensitiveWords.add(sensitiveWord2);
        sensitiveWords.add(sensitiveWord3);
        sensitiveWords.add(sensitiveWord4);
        String strings = sensitiveWordFiltering("w我是你爸爸挨了一炮，我爱中华人名共和国", sensitiveWords);
        System.out.println(strings);
    }

    public static String sensitiveWordFiltering(String text, ArrayList<SensitiveWord> sensitiveWords)
    {
        // 初始化敏感词库对象
        SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
        // 从数据库中获取敏感词对象集合（调用的方法来自Dao层，此方法是service层的实现类）
//        List<SensitiveWord> sensitiveWords = sensitiveWordDao.getSensitiveWordListAll();
        // 构建敏感词库
        Map sensitiveWordMap = sensitiveWordInit.initKeyWord(sensitiveWords);
        // 传入SensitivewordEngine类中的敏感词库
        SensitivewordEngine.sensitiveWordMap = sensitiveWordMap;
        // 得到敏感词有哪些，传入2表示获取所有敏感词
        Set<String> set = SensitivewordEngine.getSensitiveWord(text, 2);

        String s = SensitivewordEngine.replaceSensitiveWord(text, 2, "*");
        return s;
    }
}
