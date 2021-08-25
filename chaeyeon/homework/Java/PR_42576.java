import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int equalNum = 1;//동명이인 수
        Hashtable<String, Integer> ht = new Hashtable();//이름, 몇명인지
        
        //완주자 넣는다.
        for(String comp : completion){
            if(ht.containsKey(comp)){//동명이인이라면
                equalNum = ht.get(comp)+1;
                ht.replace(comp, equalNum);
            }else{
                ht.put(comp, 1);
            }
        }
        
        //완주하지 못한 선수 return
        for(String part : participant){
            if(!ht.containsKey(part)){//완주자가 아닌경우
                return part;
            }else{//동명이인인 경우와 동명이인이 아닌경우
                //int value = ht.get(part);
                if(ht.get(part) == 0){//같은이름이지만 완주하지 못한 경우
                    return part;
                }else {//같은이름이 1명 이상일 경우
                    equalNum = ht.get(part) - 1;
                    ht.replace(part, equalNum);
                }
            }
            answer = part;
        }
        
        return answer;
    }
}