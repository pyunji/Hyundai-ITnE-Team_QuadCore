import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_9322 {
    static Map<Integer, Integer> patternMap; // 암호화 패턴을 저장할 맵
    static int n; // 한 문장의 단어 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseSize = Integer.parseInt(br.readLine());
        String[] publicKey1; // 제 1 공개키
        String[] publicKey2; // 제 2 공개키
        String[] encoded; // 암호문
        for (int i = 0; i < caseSize; i++) {
            n = Integer.parseInt(br.readLine());

            publicKey1 = br.readLine().split(" ");
            publicKey2 = br.readLine().split(" ");

            findOutPattern(publicKey1, publicKey2);

            encoded = br.readLine().split(" ");

            String decoded = decodeStr(encoded);
            bw.write(decoded + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 암호화 패턴을 찾아내 맵으로 저장하는 함수
    // 제 2 공개키가 제 1 공개키로부터 어떻게 암호화됐는지 찾는다
    public static void findOutPattern(String[] publicKey1, String[] publicKey2) {
        patternMap = new HashMap<>();
        List<String> pk2List = Arrays.asList(publicKey2); // List의 indexOf 메서드를 사용하기 위해 배열을 List로 변환
        for (int i = 0; i < n; i++) {
            // 제1공개키의 글자의 인덱스(key)가 제2공개키의 글자의 몇번째 인덱스(value)로 변환되었는지 확인한다.
            patternMap.put(i, pk2List.indexOf(publicKey1[i]));
        }
    }

    // 암호화 패턴맵인 patternMap을 이용해 암호문을 해독해서 평문으로 반환하는 함수
    public static String decodeStr(String[] encoded) {
        String[] decoded = new String[n];

        for (Map.Entry<Integer, Integer> entry : patternMap.entrySet()) {
            // key -> value로 암호화된 규칙을 이용해 평문을 복구한다.
            // 암호문에 value -> key 방식으로 패턴을 역으로 적용하면 평문이 나온다.
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            decoded[key] = encoded[value];
        }

        return String.join(" ", decoded);
    }
}
