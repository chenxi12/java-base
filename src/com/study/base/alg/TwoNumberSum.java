package com.study.base.alg;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description：nums[2,7,11,15] 求两数之和为9 输出索引
 * @Author：libing
 * @Date：2023/5/25 20:12
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] attr = {2, 7, 11, 15};
        int[] ints = twoSumMap(attr, 9);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < length; j++) {
                int result = nums[i] + nums[j];
                if (target == result) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    private static int[] twoSumMap(int[] nums, int target) {
        //{2, 7, 11, 15};
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (valueIndexMap.containsKey(temp)) {
                return new int[]{valueIndexMap.get(temp), i};
            }
            valueIndexMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
