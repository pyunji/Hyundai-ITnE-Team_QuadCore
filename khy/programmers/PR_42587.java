import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Docs> qlist = new LinkedList<Docs>();
        ArrayList<Integer> order = new ArrayList<Integer>();
        
        for(int i=0; i<priorities.length; i++){
            qlist.offer(new Docs(i,priorities[i]));
            order.add(priorities[i]);
        }
        
        order.sort(Comparator.reverseOrder());
        
        int count = 0;
        int nowidx = 0;
        
        for(Integer n : order){
            count++;
            khy:
            while(true){
                Docs selected = qlist.poll();
                if(selected.impo == n){
                    nowidx = selected.idx;
                    break;
                }else{
                    qlist.offer(selected);
                }
            }
            if(location == nowidx){
                break;
            }
        }        
        return answer = count;
    }
    
    class Docs {
        int idx;
        int impo;
        
        Docs(int idx, int impo){
            this.idx = idx;
            this.impo = impo;
        }
    }
}