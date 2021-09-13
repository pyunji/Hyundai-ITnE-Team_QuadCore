import java.util.*;

class Solution{
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> Bridge = new LinkedList<>();
    for(int i = 0; i< bridge_length; i++)
    Bridge.offer(0);

    int i =0;
    int curTruck;
    int seconds =0;

    while(i < truck_weights.length){
      curTruck = truck_weights[i];
      weight += Bridge.poll();
      if(curTruck <= weight){
        onBridge.offer(curTruck);
        weight -= curTruck;
        i++;
      } else{
        Bridge.offer(0);
      }seconds++;
    }
    return seconds + bridge_length;
  }

}