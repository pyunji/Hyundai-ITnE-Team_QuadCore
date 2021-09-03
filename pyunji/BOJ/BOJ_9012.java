import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            bw.write(isVps(br.readLine()));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static String isVps(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ps = str.charAt(i);
            if(ps == '(') {
                stack.push(ps);
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    return "NO\n";
                }
            }
        }
        if(stack.isEmpty()) return "YES\n";
        else {
            stack.clear();
            return "NO\n";
        }
    }
}
