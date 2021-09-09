import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        
        for(int i=0; i < priorities.length; i++){
            priorityQueue.offer(priorities[i]);
        }        
        
        while(!priorityQueue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorityQueue.peek() == priorities[i]){
                    ++answer;
                    priorityQueue.poll();
                    
                    if(i == location){
                        priorityQueue.clear();
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
