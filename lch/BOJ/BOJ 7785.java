import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      Map<String, Integer> map = new HashMap<>();
        String[] strs;
        for (int i = 0; i < N; i++) {
            strs = br.readLine().split(" "); 
            String name = strs[0]; 
            if (map.containKey(name)) {  
                map.remove(name);
            } else map.put(name, 0);
        }
        List<String> memberList = new ArrayList(map.keySet());
        memberList.sort(Comparator.reverseOrder());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : memberList) {
            bw.write(s+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
        
    }
}