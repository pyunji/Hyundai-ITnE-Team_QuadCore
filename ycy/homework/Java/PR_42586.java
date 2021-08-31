import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
        Stack<Integer> stack = new Stack<Integer>();
        
        //stack에 배포일수 d-day 담기
        for(int i=progresses.length-1; i>=0; i--){
            stack.push( (int) Math.ceil( (double) ( (100 - progresses[i]) /(double)speeds[i] ) ) );
        }
        
        //stack에서 값 꺼내서 배포 기능갯수로 담기
        int Maxday=0;
        int num=0;
        ArrayList<Integer> waitList = new ArrayList();
        while(!stack.empty()){
            int day = stack.pop();
            if(waitList.size() == 0){
            	waitList.add(1);
                Maxday=day;
                num++;
            }else{
                if(Maxday >= day){
                	int store = waitList.get(num-1)+1;
                	waitList.remove(num-1);
                	waitList.add(store);
                }else{
                	waitList.add(1);
                    Maxday=day;
                    num++;
                }
            }
        }
        answer = new int[waitList.size()];
        for(int i=0; i<waitList.size(); i++) {
        	answer[i] = waitList.get(i);
        }

        for(int j=0; j<answer.length; j++) {
        	System.out.println(answer[j]);
        }
        
        return answer;
    }
}