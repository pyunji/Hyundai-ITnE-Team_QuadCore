import java.util.*;
import java.io.*;

class Solution {
    boolean[] check;
    String route="";
    ArrayList<String> answers = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String start;
        String end;
        
        for(int i=0; i<tickets.length; i++){
            start = tickets[i][0];
            end = tickets[i][1];
            if(start.equals("ICN")){
                route = start + " ";
                check = new boolean[tickets.length];
                check[i] = true;
                dfs(tickets, end, 1);
            }
        }
        
        answers.sort(Comparator.naturalOrder());
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String[][] tickets, String target, int cnt){
        route += target + " ";
        if(cnt == tickets.length){
            answers.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(start.equals(target) && check[i] == false){
                check[i] = true;
                dfs(tickets, end, cnt+1);
                check[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
        
    }
    
}