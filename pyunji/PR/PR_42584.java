import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
                int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && (prices[stack.peek()] > prices[i] || i == prices.length - 1)) {
                Integer index = stack.pop();
                answer[index] = i-index;
            }
            stack.push(i);
        }
        return answer;
    }
}