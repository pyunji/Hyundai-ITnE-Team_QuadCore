import java.util.*;

class Solution {
    private boolean[] checked;
    private List<String> networks = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        checked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs (int[][] computers, int i) {
        checked[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !checked[j]) dfs(computers, j);
        }
    }
}