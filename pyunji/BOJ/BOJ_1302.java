import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            bookMap.put(name, bookMap.getOrDefault(name, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry1.getValue() < entry2.getValue()) return 1;
                else if (entry1.getValue() == entry2.getValue()) {
                  // String클래스가 가지는 compareTo 메서드 사용해서 int값 반환
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                else return -1;
            }
        };
        List<Map.Entry<String, Integer>> answerList = new ArrayList<>(bookMap.entrySet());
        answerList.sort(comp);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answerList.get(0).getKey());
        bw.flush();
        br.close();
        bw.close();
    }
}