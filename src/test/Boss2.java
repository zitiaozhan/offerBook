/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/9
 */
public class Boss2 {

    private ConcurrentHashMap<String, Integer> ipAndCountMap = new ConcurrentHashMap<>();

    public int access(String ip) {
        return ipAndCountMap.merge(ip, 1, (o, n) -> o + 1);
    }

    public static void main(String... args) {
        Boss2 boss2 = new Boss2();
        System.out.println(boss2.access("1234"));
        System.out.println(boss2.access("1234"));

        HashSet<User> users = new HashSet<>();
        User user = new User();
        user.setAge(20);
        users.add(user);
        user.setAge(21);
        System.out.println(users.contains(user));

        System.out.println(getTranslateResult());
    }

    public static String getTranslateResult() {
        CompletableFuture<String> googleFuture = CompletableFuture.supplyAsync(() -> {
            // 调用谷歌翻译
            return "google";
        });
        CompletableFuture<String> baiduFuture = CompletableFuture.supplyAsync(() -> {
            // 调用百度翻译
            return "baidu";
        });
        Object join = CompletableFuture.anyOf(googleFuture, baiduFuture).join();

        return join.toString();
    }

}