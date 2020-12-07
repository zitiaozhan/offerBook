/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/12/7
 */
public class MinArray2 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1, mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // 针对重复元素数组
                right--;
            }
        }

        return numbers[left];
    }

    public static void main(String... args) {
        MinArray2 minArray2 = new MinArray2();
        System.out.println(minArray2.minArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(minArray2.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray2.minArray(new int[]{5, 1, 2, 3, 4}));
        System.out.println(minArray2.minArray(new int[]{2, 3, 4, 5, 1}));
        System.out.println(minArray2.minArray(new int[]{4, 5, 1, 2, 3}));
    }
}