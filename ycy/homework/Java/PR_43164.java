import java.util.*;
import java.io.*;

class Solution {
    ArrayList<String> answers = new ArrayList<>();
    boolean[] check;
    String route = "";
    
    public String[] solution(String[][] tickets) {
       
       /* 중요 : 티켓이 인천으로 시작할 경우 완전탐색을 시작해야하므로
          check를 초기화한후 실행해야한다.*/
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                check = new boolean[tickets.length];
                route = tickets[i][0] + ",";
                check[i] = true;
                dfs(tickets, tickets[i][1], 1);
            }
        }
        
        answers.sort(Comparator.naturalOrder());
        //Collections.sort(answers);
        String[] answer = answers.get(0).split(",");
        
        return answer;
    }
    
    public void dfs(String[][] tickets, String end, int cnt){
        route += end + ",";
        if(cnt == tickets.length){
            answers.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            //방문하지 않은 티켓중 이전 도착지와 출발지가 동일할 경우 재귀호출 
            if(tickets[i][0].equals(end) && !check[i]){
                check[i] = true;
                dfs(tickets, tickets[i][1], cnt+1);
                check[i] = false;
                route = route.substring(0,route.length()-4);
            }
        }
    }
    
}