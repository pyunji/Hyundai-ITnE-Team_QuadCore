import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Hashtable<String, Integer> ht = new Hashtable();
        String key;
        int value;
        
        for(int i=0; i<clothes.length ; i++){//옷의 종류(key)와 수(value)를 넣는다.
            key = clothes[i][1];
            if(ht.containsKey(clothes[i][1])){
                value = ht.get(clothes[i][1])+1;
            }else{
                value = 1;
            }
            ht.put(key, value);
        }
        
        //옷의 종류가 1개일 경우
        if(ht.size() == 1){
            return clothes.length;
        }else{//ht의 value들을 곱한다.
            for(int val : ht.values()){
                answer *= (val+1);
            }
            
        }
        
        return answer-1;
    
    }
    
}