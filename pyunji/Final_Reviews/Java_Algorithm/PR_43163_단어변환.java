/**
 * using DFS
 * 42m 소요
 */

 /**
 최단 경로 찾는 문제 -> false 처리가 필요한 문제로 분류하자
  */
class Solution {
    boolean[] chk;
    int answer = Integer.MAX_VALUE;
    /* 유틸 메서드 정의 */
    public boolean canConvert(String start, String end) {
        int count = 0;
        for(int j = 0; j < start.length(); j++) {
            if (start.charAt(j) != end.charAt(j)) count++;
        }
        return count==1;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        /* 3. 재귀 탈출 조건 정의 */
        if(begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        /* 4. 루프를 돌릴 탐색 범위 설정 */
        for(int i = 0; i < words.length; i++) {
            /* 5. 탐색 성공 조건 설정 */
            if(!chk[i] && canConvert(begin, words[i])) {
                /* 6. 방문 true -> dfs -> 방문 false */
                chk[i] = true;
                dfs(words[i], target, words, count + 1);
                chk[i] = false;
            }
        }
    }

    
    public int solution(String begin, String target, String[] words) {
        /* 0. 예외 케이스 우선 리턴 */
        boolean convertCheck = false;
        for(int k = 0; k < words.length; k++) {
            if (words[k].equals(target)) {
                convertCheck = true;
            }
        }
        
        if(!convertCheck) return 0;

        /* 1. 데이터 초기화 */
        chk = new boolean[words.length];
        
        /* 2. 문제에서 진입 조건을 정해주므로 루프를 돌면서 dfs 진입 가능한 좌표를 찾을 필요가 없음 */
        dfs(begin, target, words, 0);

        return answer;
    }
}