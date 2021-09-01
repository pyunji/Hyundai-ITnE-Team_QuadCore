import java.io.*;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= stack.pop();
            } else {
                stack.push(num);
                sum += num;
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}