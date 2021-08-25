import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        int answer = 1;
        for (String[] clothe : clothes) {
            String key = clothe[1]; // 의상의 종류
            String value = clothe[0];   // 의상의 이름
            List<String> list;
            // 의상의 종류 별로 의상의 이름을 list에 추가한다.
            if(map.containsKey(key)) list = map.get(key);
            else list = new LinkedList<>();

            list.add(value);
            map.put(key, list);
        }

        // 의상의 종류에 투명 옷을 추가한다.
        for (List<String> values : map.values()) answer *= (values.size() + 1);
        // 모든 종류를 투명 옷만 입은 경우를 빼준다
        return answer - 1;
    }
}