import java.io.*;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLine = br.readLine().split(" ");
        int K = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);
        long[] lans = new long[K];
        // 랜선의 최댓값 저장
        long maxLan = 0;
        for (int i = 0; i < K; i++) {
            long inputInt = Integer.parseInt(br.readLine());
            lans[i] = inputInt;
            if (inputInt > maxLan) maxLan = inputInt;
        }
        long start = 0;
        long end = maxLan;
        long mid;
        long lanCount;
        long answer = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            lanCount = cutting(lans, mid);
            if (lanCount < N) {
                end = mid - 1;

            } else if (lanCount >= N) {
                start = mid + 1;
                answer = mid;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static long cutting(long[] lans, long cutLen) {
        long lanCount = 0;
        for (long lan : lans) {
            lanCount += lan / cutLen;
        }
        return lanCount;
    }
}