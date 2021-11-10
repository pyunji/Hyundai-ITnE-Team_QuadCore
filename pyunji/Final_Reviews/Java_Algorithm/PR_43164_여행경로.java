/*
using DFS
9m 소요
*/
import java.util.*;

class Solution {
    boolean[] chk;
    List<String> answerList = new ArrayList<>();    
    public void dfs(String start, int count, String path, String[][] tickets) {
        /* 3. 재귀 탈출 조건 정의 */
        if(count == tickets.length) {
            answerList.add(path);
            return;
        }
        /* 4. 루프를 돌릴 탐색 범위 설정 */
        for(int i = 0; i < tickets.length; i++) {
            /* 5. 탐색 성공 조건 설정 */
            if (!chk[i] && tickets[i][0].equals(start)) {
                /* 6. 방문 true -> dfs -> 방문 false */
                chk[i] = true;
                dfs(tickets[i][1], count + 1, path + " " + tickets[i][1], tickets);
                chk[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        /* 0. 데이터 초기화 */
        chk = new boolean[tickets.length];
        
        /* 1. 문제에서 진입 조건을 정해주므로 루프를 돌면서 dfs 진입 가능한 좌표를 찾을 필요가 없음 */
        dfs("ICN", 0, "ICN", tickets);
        
        Collections.sort(answerList);
        
        return answerList.get(0).split(" ");
    }
}