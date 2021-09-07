import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// 이해해보기!
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> List = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = progresses.length-1; i >=0; i--) {
            // 뒤의 작업부터 남은 날짜를 계산해서 스택에 추가
            stack.push((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        int waiting = 1; // 배포를 기다리는 작업의 수
        int ToWait = stack.pop(); // 다른 작업의 배포를 기다리게 만든 작업의 남은 날짜
        Integer currJob; // n번째 기능

        while (!stack.isEmpty()) {
            currJob = stack.pop();
            if (currJob > ToWait) { // 뒤의 기능이 앞선 기능보다 더 오래 걸리면
                List.add(waiting); // 현재까지의 기능을 배포
                ToWait = currJob; // 더 오래걸리는 뒤의 기능으로 변수 갱신
                waiting = 1; // 기다리는 작업의 수를 1로 갱신
            } else { // 앞선 기능보다 뒤의 기능이 빨리 만들어졌다면
                waiting++; // 배포를 기다린다
            }
        }
        List.add(waiting); // 마지막으로 계산된 waitingJobs를 더해준다.

        return List.stream().mapToInt(i->i).toArray();

    }
}