package task_01_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] nums;
    int target;

    public Solution(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public void printResultTwoSum() {
        System.out.println(Arrays.toString(this.twoSumHashMap()));
        System.out.println();
    }

    public int[] twoSum() {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int elementsSum = nums[i] + nums[j];
                if (elementsSum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSumHashMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
