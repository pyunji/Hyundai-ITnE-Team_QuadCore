import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = {};
        answer = new int[prices.length];
        Stack<Integer> priceStack = new Stack();
        for(int i=prices.length-1; i>=0; i--){
            priceStack.push(prices[i]);
        }
        
        int idx = 0;
        while(!priceStack.isEmpty()){
            int popedNum = priceStack.pop();
            int count = 0;
            for(int i=idx+1;i<prices.length;i++){
                if(popedNum<=prices[i]){
                    count++;
                }else{
                    count++;
                    break;
                }
            }
            answer[idx] = count;
            idx++;
        }
        
        return answer;
    }
}