import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> needDay= new Stack();
        ArrayList<Integer> result = new ArrayList();
        
        for(int i=progresses.length-1; i>=0; i--){
            int calc = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]==0){
                needDay.push(calc);
            }else{
                needDay.push(calc+1);
            }
        }
        
        while(!needDay.isEmpty()){
           int curr = needDay.pop();
           int releaseCount = fun(curr,needDay,1);
           result.add(releaseCount);
        }
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public int fun(int curr, Stack<Integer> needDay, int count){
        if(needDay.isEmpty()||curr<needDay.peek()){
            return count;   
        }else{
            needDay.pop();
            return fun(curr,needDay,count+1);
        }
        
    }
}