package com.czff.study.knowledge.collection.looptraversal;

/**
 * @author 疾风劲草
 * @date 2023/7/28 18:53
 * @description 循环标记
 */
public class LoopTag {
    public static void main(String[] args) {
        retry:
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if(j == 3) {
                    continue retry;   // 输出：0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3,  >>> OK
                    // break retry;    // 输出：0, 1, 2, 3,  >>> OK
                }
            }
        }

    }
}
