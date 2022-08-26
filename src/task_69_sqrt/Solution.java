package task_69_sqrt;

public class Solution {

    // first version
    public int mySqrtFirst(int x) {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            if (x < i * i) {
                return (int) i - 1;
            }
            System.out.println("i = " + i);
        }
        return 0;
    }

    // fast version
    public int mySqrt(int x) {
        long result = x;
        while (result * result > x) {
            result = (result + x / result) / 2;
        }

        return (int) result;
    }

    public int mySqrtBinarySearch(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x / 2;
        while (low < high) {
            int mid = (low + (high - low) / 2) + 1;
            int div = x / mid;
            if (div == mid) {
                return mid;
            }
            if (div > mid) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public void printSolution(int x) {
        System.out.println("");
        System.out.println("Taks69. sqrt(x): x = " + x);
        System.out.println("Результат: " + mySqrt(x));
    }
}
