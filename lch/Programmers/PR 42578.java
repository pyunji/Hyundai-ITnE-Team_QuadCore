import java.io.*;
import java.util.*;
 
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap();
        int total = 1; 
        int answer = 0;
        for(int i=0; i<clothes.length; i++){ 
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }
        for(int count : map.values()){
            total*=count;
        }
        answer = total - 1;
        return answer;
    }
}