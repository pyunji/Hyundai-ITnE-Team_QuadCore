import java.util.*;

class Solution {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		int answer = 1;
		for (int i = 0; i < clothes.length; i++) {
			// 옷 종류, 갯수
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
		// 아무것도 안입는 경우의 수 제거
		answer = -1;
		return answer;
	}
}

