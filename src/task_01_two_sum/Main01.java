package task_01_two_sum;

import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {
        Solution solution1 = new Solution(new int[] {2, 7, 11, 15}, 9);
        solution1.printResultTwoSum();
        Solution solution2 = new Solution(new int[] {3, 2, 4}, 6);
        solution2.printResultTwoSum();
        Solution solution3 = new Solution(new int[] {3, 3}, 6);
        solution3.printResultTwoSum();
    }
}
