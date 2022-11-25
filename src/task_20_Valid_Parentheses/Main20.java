package task_20_Valid_Parentheses;

public class Main20 {
    public static void main(String[] args) {
        Solution solution1 = new Solution();
        solution1.printSolution("()");
        solution1.printSolution("()[]{}");
        solution1.printSolution("(]");
        solution1.printSolution("{[]}");
        solution1.printSolution("[");
        solution1.printSolution("]");
    }
}
