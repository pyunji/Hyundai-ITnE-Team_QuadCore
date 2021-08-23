import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String parti: participant) {
            map.put(parti, map.getOrDefault(parti, 0) + 1);
        }
        for (String comp: completion) {
            map.put(comp, map.get(comp) - 1);
        }
        String answer="";
        for (String key : map.keySet()) {
            if(map.get(key) == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}