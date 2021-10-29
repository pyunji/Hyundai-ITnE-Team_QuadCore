import java.util.*;

class Solution {
    boolean check[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++){
            if(check[i] == false){
                check[i] = true;
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int target){
        for(int i=0; i<computers.length; i++){
            if(i!=target && computers[i][target] == 1 && check[i]==false){
                check[i]=true;
                dfs(computers, i);
            }
        }
    }
}