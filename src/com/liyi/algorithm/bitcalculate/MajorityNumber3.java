package com.liyi.algorithm.bitcalculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityNumber3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[]{7, 1, 7, 7, 61, 61, 61, 10, 10, 10, 61};
        for (int i : nums) {
            list.add(i);
        }
        majorityNumber(list, 3);
    }

    public static int majorityNumber(List<Integer> nums, int k) {
        if (nums == null || nums.isEmpty()) {
            return -1;
        }

        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            if (maps.containsKey(temp)) {
                int value = maps.get(temp);
                maps.put(temp, value + 1);
            } else {
                maps.put(temp, 1);
            }

            if (maps.size() >= k) {
                removeKey(maps);
            }
        }

        if (maps.size() == 0) {
            return -1;
        }

        for (Integer i : maps.keySet()) {
            maps.put(i, 0);
        }

        int maxKey = 0;
        int maxVlaue = 0;
        for (int i : nums) {
            if (maps.containsKey(i)) {
                maps.put(i, maps.get(i) + 1);
            }

            int temp = maps.get(i) == null ? -1 : maps.get(i);
            maxVlaue = Math.max(maxVlaue, temp);

            if (maxVlaue == temp) {
                maxKey = i;
            }
        }

        return maxKey;
    }

    private static void removeKey(HashMap<Integer, Integer> maps) {
        if (maps == null || maps.size() == 0) {
            return;
        }
        List<Integer> shouldRemove = new ArrayList<>();
        for (Integer i : maps.keySet()) {
            int value = maps.get(i);
            if (value - 1 == 0) {
                shouldRemove.add(i);
            } else {
                maps.put(i, value - 1);
            }
        }

        for (Integer i : shouldRemove) {
            maps.remove(i);
        }
    }
}