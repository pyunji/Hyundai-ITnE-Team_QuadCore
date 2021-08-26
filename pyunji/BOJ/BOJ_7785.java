import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] strs;
        for (int i = 0; i < N; i++) {
            strs = br.readLine().split(" "); // 한 줄을 읽어 공백으로 자른 후 배열에 저장
            String name = strs[0];  // 이름만 가져옴
            if (map.containsKey(name)) {  // 이미 맵에 등록된 사원이 또 들어오면 퇴근했다는 것이므로 맵에서 지움
                map.remove(name);
            } else map.put(name, 0);
        }
        List<String> memberList = new ArrayList(map.keySet());
        // 사전 역순으로 이름 정렬
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
