import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        //String 옷의 종류, Integer 갯수
        HashMap<String,Integer> hm = new HashMap();
        //가능한 의상조합의 합계
        int total = 1; 
        int answer = 0;
        
        //의상을 종류에 따라 hash에 카운트한다.
        //옷을 안입는 경우도 한개의 경우이므로 default로 1을 넣는다. 
        for(int i=0; i<clothes.length; i++){ 
            hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],1)+1);
        }
        
        for(int count : hm.values()){
            total*=count;
        }
        
        //아무것도 안입는 경우 1을 빼준다.
        answer = total - 1;
        return answer;
    }
}