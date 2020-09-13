/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item4;

/**
 * P44
 * 在二维数组中查找数字
 *
 * @author xingye
 * @created 2020/9/12
 */
public class FindNumIn2DArray2 {

    // 最好时间复杂度：O(1)
    // 最坏时间复杂度：O(M+N)
    // 平均时间复杂度：
    // 在数组中：1/2
    // 不在数组中：1/2
    private boolean findNum(int[][] nums, int num) {
        if (null == nums || 0 == nums.length || 0 == nums[0].length) {
            return false;
        }

        // 二维数组第一行最右数字
        int line = 0;
        int row = nums[0].length - 1;
        while (line < nums.length && row >= 0) {
            int curNum = nums[line][row];
            if (curNum == num) {
                return true;
            } else if (curNum > num) {
                // 排除一列
                row--;
            } else {
                // 排除一行
                line++;
            }
        }

        return false;
    }

    public static void main(String... args) {
        FindNumIn2DArray2 findNumInArray = new FindNumIn2DArray2();
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(findNumInArray.findNum(nums, 3));
        System.out.println(findNumInArray.findNum(nums, 1));
        System.out.println(findNumInArray.findNum(nums, 15));
        System.out.println(findNumInArray.findNum(nums, 6));
        System.out.println(findNumInArray.findNum(nums, 11));
        System.out.println(findNumInArray.findNum(nums, 4));
        System.out.println(findNumInArray.findNum(nums, 5));
    }

}