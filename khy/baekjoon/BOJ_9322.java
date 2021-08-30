import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			HashMap<String, Integer> wordWithIdx = new HashMap();
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			String firstKey = br.readLine();
			st = new StringTokenizer(firstKey);
			
			for(int j=0; j<N; j++) {
				wordWithIdx.put(st.nextToken(),j);
			}
			
			String secondKey = br.readLine();
			st = new StringTokenizer(secondKey);
			
			for(int j=0; j<N; j++) {
				arr[j] = wordWithIdx.get(st.nextToken());
			}
			
			String[] normal = new String[N];
			String secretKey = br.readLine();
			st = new StringTokenizer(secretKey);
			for(int j=0; j<N; j++) {
				normal[arr[j]] = st.nextToken();
			}
			
			for(int j=0; j<N; j++) {
				sb.append(normal[j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
