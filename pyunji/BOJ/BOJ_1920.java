import java.io.*;
import java.util.Arrays;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            int mid;
            int target = Integer.parseInt(s2[i]);
            int answer = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                if (A[mid] < target) {
                    start = mid + 1;
                } else if (A[mid] > target) {
                    end = mid - 1;
                } else {
                    answer = 1;
                    break;
                }
            }
            System.out.println(answer);
        }

    }
}