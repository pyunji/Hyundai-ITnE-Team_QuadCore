import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Stack < String > stack = new Stack < > ();
            String[] strArray = br.readLine().split("");
            boolean isVPS = false;

            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].equals("(")) {
                    stack.push(strArray[j]);
                } else {
                    if (stack.isEmpty() == true) {
                        isVPS = false;
                        break;
                    } else {
                        isVPS = true;
                        stack.pop();
                    }
                }
            }
            if (isVPS == true && stack.isEmpty() == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}