class Solution {
    //네트워크가 연결되어있는지 안되어있는지 check
    static int[] check;
    static int N;
 
        public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        check = new int[n];
        // 네트워크 개수 count
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(check[i] != 1){
                count++;
                bfs(i,computers);
            }
        }
        answer = count;
        return answer;
    }
    
    public void bfs(int comNum,int[][] computers){
        check[comNum] = 1;
        for(int i=0; i<N; i++){
            if(computers[comNum][i] == 1 && check[i] != 1){
                bfs(i,computers);
            }
        }
    }
}