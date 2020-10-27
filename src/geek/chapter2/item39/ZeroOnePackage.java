/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item39;

/**
 * 0-1背包
 * 现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。
 * 在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 * https://time.geekbang.org/column/article/74287
 *
 * @author xingye
 * @created 2020/10/27
 */
public class ZeroOnePackage {
    private int max = Integer.MIN_VALUE;

    private void zeroAndOne(int curIndex, int packageRoom, int curUsed, int[] rooms) {
        if (curIndex == rooms.length || curUsed == packageRoom) {
            if (curUsed > max) {
                max = curUsed;
            }
            return;
        }

        // 不装载当前物品
        zeroAndOne(curIndex + 1, packageRoom, curUsed, rooms);
        // 装载当前物品
        if (curUsed + rooms[curIndex] <= packageRoom) {
            zeroAndOne(curIndex + 1, packageRoom, curUsed + rooms[curIndex], rooms);
        }
    }

    public static void main(String... args) {
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        zeroOnePackage.zeroAndOne(0, 29, 0, new int[]{7, 3, 5, 9, 10, 23, 6, 8});
        System.out.println(zeroOnePackage.max);
    }
}