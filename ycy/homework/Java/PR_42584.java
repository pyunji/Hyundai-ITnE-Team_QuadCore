import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<prices.length; i++){
            while( !stack.empty() && prices[stack.peek()] > prices[i] ){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            
        }
        
        while(!stack.empty()){
            answer[stack.peek()] = prices.length - stack.peek() -1;
            stack.pop();
        }
        
        
        return answer;
    }
}