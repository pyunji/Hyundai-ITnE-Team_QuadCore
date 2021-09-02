import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];  // 정답 int를 담을 배열을 prices의 length를 이용해 선언하고 초기화한다.
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < prices.length; i++) {
            // stack이 비어있지 않은 경우 -> 필수 조건
            // stack의 최댓값보다 이후에 들어올 값이 큰 경우
            // or 마지막번째 주식가격이 들어올 차례인 경우
            while (!stack.isEmpty() && (prices[stack.peek()] > prices[i] || i == prices.length - 1)) {
                Integer index = stack.pop(); // stack의 top요소를 꺼낸다.
                answer[index] = i-index;    // 꺼낸 top요소가 가리키는 인덱스를 이용해 answer 배열에 할당한다
                // i-index => 하락하지 않은 날짜 계산
            }
            stack.push(i); // 현재 값의 인덱스를 넣는다.
        }
        return answer;
    }
}