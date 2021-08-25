import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //key에 이름, value 사람 수
        HashMap<String,Integer> hm = new HashMap();
        
        //for문을 돌면서 hm에 이름과, 사람수를 넣는다.
        for(String name : participant){
            //getOrDefault를 활용해서 
            //해당 key가 put된적 있다면 해당 key의 value값+1을 value에 넣고 
            //해당 key가 없다면 0+1을 넣도록 만들었다.
            hm.put(name,hm.getOrDefault(name,0)+1); 
        }
        
        //for문을 돌면서 완주자를 hm의 사람수에서 뺀다.
        for(String name : completion){
            if(hm.containsKey(name)){
                hm.put(name,hm.getOrDefault(name,0)-1);
            }
        }
        
        //key값들만 set으로 받아온다.
        Set<String> names = hm.keySet();
        
        //key값들을 hm에 넣어 value가 0이 아닌것을 answer에 담는다.
        for(String name : names){
            if(hm.get(name)!=0){
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}