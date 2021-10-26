import java.util.*;

class Solution {
    boolean[] visited;
    List<String> answerArr = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(answerArr);
    
        return answerArr.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String start, String path, int count) {
        if (count == tickets.length) {
            answerArr.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}