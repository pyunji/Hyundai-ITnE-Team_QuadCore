import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
    int N = Integer.parseInt(br.readLine());
    StringTokenizer cards = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringTokenizer targets = new StringTokenizer(br.readLine());

    String[] answers = new String[M];
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {   // 카드의 숫자와 카드의 개수를 키와 밸류로 저장한다.
        String key = cards.nextToken();
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    // 타겟에 해당하는 카드의 개수를 가져오고, 없으면 0을 가져온다. 
    // String의 join메서드를 사용하기 위해 String으로 변환해 가져왔다.
    for (int i = 0; i < M; i++) answers[i] = String.valueOf(map.getOrDefault(targets.nextToken(), 0));

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.join(" ", answers));
    bw.flush();
    br.close();
    bw.close();
    }
}