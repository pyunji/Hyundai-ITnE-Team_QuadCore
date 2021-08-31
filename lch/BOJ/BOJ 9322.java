import java.io.*;
import java.util.*;
 
public class Main {
    static Map<Integer, Integer> patternMap; 
    static int N; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Size = Integer.parseInt(br.readLine());
        String[] Key1; 
        String[] Key2; 
        String[] cpg; 
        for (int i = 0; i < Size; i++) {
            N = Integer.parseInt(br.readLine());
            Key1 = br.readLine().split(" ");
            Key2 = br.readLine().split(" ");
            findOutPattern(Key1, Key2);
            cpg = br.readLine().split(" ");
            String decoded = decodeStr(cpg);
            bw.write(decoded + "\N");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void findOutPattern(String[] Key1, String[] Key2) {
        patternMap = new HashMap<>();
        List<String> pk2List = Arrays.asList(Key2); 
        for (int i = 0; i < n; i++) {

            patternMap.put(i, pk2List.indexOf(Key1[i]));
        }
    }

    public static String decodeStr(String[] cpg) {
        String[] decoded = new String[n];

        for (Map.Entry<Integer, Integer> entry : patternMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            decoded[key] = cpg[value];
        }

        return String.join(" ", decoded);
    }
}