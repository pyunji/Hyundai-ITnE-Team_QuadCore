import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;//시간
        int curWeight=0;//현재 다리위 트럭의 무게
        Queue<Integer> tQueue = new LinkedList<Integer>();
        Queue<Integer> tWeightQueue = new LinkedList<Integer>();
        for(int i=0; i<truck_weights.length; i++){
            tWeightQueue.offer(truck_weights[i]);
        }
        
        //트럭이 들어있는 큐가 비면 종료
        while(!tWeightQueue.isEmpty()){
            //큐가 비어있으면, 트럭을 올린다.
            if(tQueue.isEmpty()){
                curWeight += tWeightQueue.peek();
                tQueue.offer(tWeightQueue.poll());
                time++;
            //큐가 비어있지 않고 
            //bridge_length를 초과하지 않고
            }else if(tQueue.size() < bridge_length){
                //트럭 무게가 weights를 초과하지 않으면 트럭을 올린다
                if(weight >= curWeight+tWeightQueue.peek()){ 
                    curWeight += tWeightQueue.peek();
                    tQueue.offer(tWeightQueue.poll());
                }else{ //트럭 무게가 weights를 초과하면 0을 더해준다
                    tQueue.offer(0);
                }
                time++;
            //bridge_length를 가 찼으면 빼준다
            }else{
                curWeight -= tQueue.poll();
            }
        }
        
        //마지막 트럭에서 반복문 종료되는데, 마지막 트럭도 다리 길이만큼 증가
        return time+bridge_length;
    }
}