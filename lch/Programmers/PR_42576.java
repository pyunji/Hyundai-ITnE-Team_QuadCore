import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
        for(String part : participant){
            map.put(part, map.getOrDefault(part, 0) + 1);    // getOrDefault(key, defaultValue) : map에서 찾는 Key가 없다면 defaultValue를 리턴한다.
        }
        for(String comp : completion){
            map.put(comp, map.get(comp)-1); // 같은 문자열을 찾아 value의 값을 -1 해준다.
        }
       for (Entry<String, Integer> entry : map.entrySet()) {  // Entry 객체 자체를 Set으로 가져옴
			if (entry.getValue() > 0) {
				answer = entry.getKey();
				break;
			}
		}
        return answer;
    }
}