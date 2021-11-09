/**
 * using DFS
 * 10m 소요
 */
class Solution {
    int[][] arr;
    boolean[][] chk;
    int N;
    public void dfs(int a, int b) {
        chk[a][b] = true;
        for (int j = 0; j < N; j++) {
            if (!chk[b][j] && arr[b][j] == 1) {
                dfs(b, j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        arr = computers;
        N = n;
        chk = new boolean[n][n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!chk[i][j] && arr[i][j] == 1) {
                    answer++;
                    dfs(i, j);
                }
            }
        }
        
        return answer;
    }
}