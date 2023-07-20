package com.czff.mydemo.leetcode.easy;

/**
 * @author cuidi
 * @description 搜索插入位置 二分法
 * 二分法模板
 * class Solution {
 *     public int searchInsert(int[] nums, int target) {
 *         int left = 0, right = nums.length - 1; // 注意
 *         while(left <= right) { // 注意
 *             int mid = (left + right) / 2; // 注意
 *             if(nums[mid] == target) { // 注意
 *                 // 相关逻辑
 *             } else if(nums[mid] < target) {
 *                 left = mid + 1; // 注意
 *             } else {
 *                 right = mid - 1; // 注意
 *             }
 *         }
 *         // 相关返回值
 *         return 0;
 *     }
 * }
 *
 * 作者：guanpengchn
 * 链接：https://leetcode.cn/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 作者：guanpengchn
 * 链接：https://leetcode.cn/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/25 16:17
 */
public class SearchInsertionLocation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int location = searchInsertLocation(nums, target);
        System.out.println(location);
    }

    /**
     * 标签：二分查找
     * 如果该题目暴力解决的话需要 O(n) 的时间复杂度，但是如果二分的话则可以降低到 O(logn) 的时间复杂度
     * 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
     * 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
     * 查找结束如果没有相等值则返回 left，该值为插入位置
     * 时间复杂度： O(logn)
     */
    public static int searchInsertLocation(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 暴力解法
     */
    public static int searchInsertLocation2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
