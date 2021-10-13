import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic_BinarySearch2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[] dducks = new int[n];
        int i = 0;
        for(String str:br.readLine().split(" ")) {
            dducks[i] = Integer.parseInt(str);
            i++;
        }

        int longDduck = dducks[n-1];
        int sumLength;
        int start = 0;
        // 절단기는 가장 긴 떡보다 1 작아야 함
        int end = longDduck - 1;
        // 절단기의 길이는  0 < x < longDduck
        int cutLen;
        int answer = 0;
        while (start <= end) {
            cutLen = (start + end) / 2;
            sumLength = cutting(cutLen, dducks, n);
            if (sumLength < m) end = cutLen - 1;
            else {
                answer = cutLen;
                start = cutLen + 1;
            }
            System.out.println("cutLen = " + cutLen);
        }
        System.out.println(answer);
    }

    public static int cutting(int cutLen, int[] dducks, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(dducks[i] - cutLen, 0);
        }
        return sum;
    }
}