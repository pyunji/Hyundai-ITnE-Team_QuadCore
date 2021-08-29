import java.io.*;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> unknown = new HashMap<>();
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);

        String name;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            unknown.put(name, 0);
        }

        List<String> realUnknown = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (unknown.containsKey(name)) {
                realUnknown.add(name);
            }
        }

        Collections.sort(realUnknown);
        int size = realUnknown.size();
        bw.write(size+"\n");
        for (int i = 0; i < size; i++) {
            bw.write(realUnknown.get(i)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
