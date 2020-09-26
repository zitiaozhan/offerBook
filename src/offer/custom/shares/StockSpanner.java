package offer.custom.shares;

import java.util.HashMap;
import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class StockSpanner {

    private Stack<Integer> stack;
    private HashMap<Integer, Integer> hashMap;

    public StockSpanner() {
        stack = new Stack<>();
        hashMap = new HashMap<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek()) {
            count += hashMap.get(stack.peek());
            stack.pop();
        }
        stack.push(price);
        hashMap.put(price, count);
        return count;
    }

    public static void main(String... args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(32));
        System.out.println(stockSpanner.next(82));
        System.out.println(stockSpanner.next(73));
        System.out.println(stockSpanner.next(99));
        System.out.println(stockSpanner.next(91));
    }
}