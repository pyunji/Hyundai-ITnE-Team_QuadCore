import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0;
        int idx = 0;
        Queue<Integer> OnBridge = new LinkedList();
        for(int i=0; i<bridge_length; i++){
            OnBridge.offer(0);
        }
        
        while(idx<truck_weights.length){
            weight += OnBridge.poll();
            if(weight>=truck_weights[idx]){
                OnBridge.offer(truck_weights[idx]);
                weight-=truck_weights[idx];
                idx++;
            }else{
                OnBridge.offer(0);
            }
            time++;
        }
        
        
        int answer = time+bridge_length;
        
        
        
        return answer;
    }
}