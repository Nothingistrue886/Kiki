package interview.algorithm;

import java.util.HashMap;

/**
 * @author 疾风劲草
 * @date 2021/8/3 22:20
 * @description 两数求和
 */
public class TwoNumSum {

    public static void main(String[] args) {

        int[] ints = new int[]{2, 11, 7, 15};
        int target = 9;

        //int[] indexs = twoNumsSum(ints, target);
        int[] indexs = twoSumHash(ints, target);
        assert indexs != null;
        for (int index : indexs) {
            System.out.println(index);
        }
    }

    /**
     * hashmap
     * k -> v
     * 值  下标
     * @param array
     * @param target
     * @return
     */
    private static int[] twoSumHash(int[] array, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int number = target - array[i];
            if (hashMap.containsKey(number)) {
                int start = hashMap.get(number);
                return new int[]{start, i};
            }
            hashMap.put(array[i], i);
        }
        return null;
    }

    /**
     * 暴力破解
     *
     * @param array
     * @param target
     * @return
     */
    private static int[] twoNumsSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int out = array[i];
            for (int j = 1; j < array.length; j++) {
                int in = array[j];
                if (target == out + in) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
