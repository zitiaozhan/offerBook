package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> man = new ArrayList<>();
        List<String> women = new ArrayList<>();
        List<String> res = test(man, women);
        System.out.println(res);
    }

    // 男女交叉升序排队
    public static List<String> test(List<String> man, List<String> women) {
        if (man.isEmpty() || women.isEmpty()) {
            return man.isEmpty() ? women : man;
        }

        List<String> res = new ArrayList<>();

        int manNum = man.size();
        int womenNum = women.size();
        boolean manFlag = manNum > womenNum;

        int cur = 1, manIndex = 0, womenIndex = 0;
        while (true) {
            if (manFlag) {
                for (int i = 0; i < cur && manIndex < manNum; i++) {
                    res.add(man.get(manIndex++));
                }
                manFlag = false;
            } else {
                for (int i = 0; i < cur && womenIndex < womenNum; i++) {
                    res.add(women.get(womenIndex++));
                }
                manFlag = true;
            }
            if (manIndex == manNum || womenIndex == womenNum) {
                break;
            }
            cur++;
        }

        while (manIndex < manNum) {
            res.add(man.get(manIndex++));
        }
        while (womenIndex < womenNum) {
            res.add(man.get(womenIndex++));
        }
        return res;
    }
}