import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> onBridge = new LinkedList<>();
        // Queue의 사이즈를 제한하기 위해 bridge_length 만큼 0으로 채웠다.
        // 다리 길이만큼 채웠기 때문에, 개수 신경쓸 필요 없이 한 번 poll하고 한 번 offer하는 것만 가능하다.
        for (int i = 0; i < bridge_length; i++) onBridge.offer(0);
        int i = 0; // 트럭의 인덱스
        int curTruck; // 현재 진입할 트럭
        int seconds = 0; // 초
        while(i< truck_weights.length) {
            curTruck = truck_weights[i]; // 현재 진입할 트럭
            // 트럭이 다리에서 하나 빠져나오고 -> 여유 무게에 방금 빠져나온 트럭의 무게를 더해준다
            weight += onBridge.poll(); 
            // 현재 진입할 트럭 무게가 다리의 여유 무게보다 가볍거나 같으면
            if (curTruck <=weight) {
                onBridge.offer(curTruck); // 트럭을 다리에 offer 한다.
                weight -= curTruck; // 다리의 여유무게에서 트럭의 무게를 뺀다.
                i++;  // 다음 트럭을 대기시킨다.
            } else {
                onBridge.offer(0); // 시간 1초, 공간 1, 무게 0을 의미하는 0이라는 값을 집어넣는다.
            }
            seconds++;
        }
        return seconds + bridge_length;
    }
}