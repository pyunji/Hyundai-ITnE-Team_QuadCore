import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int K = Integer.parseInt(br.readLine());
  
    for (int i = 0; i < K; i++) {
      int re = Integer.parseInt(br.readLine());
      if (re == 0)  
        stack.pop(); // 0이면 스택에 저장된 top 지움
      else
        stack.push(re); // 0이 아니면 스택에 추가
    }

    int sum = 0;
    for (Integer i : stack) // 스택의 데이터를 i에 대입하여 반복
      sum += i;             // 스택에 담긴 합 구함
    System.out.println(sum);
  } 
}