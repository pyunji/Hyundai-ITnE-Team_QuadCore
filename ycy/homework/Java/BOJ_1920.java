import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
		
		while(st.hasMoreTokens()) {
			aMap.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreElements()) {
			int object = Integer.parseInt(st.nextToken());
			if(aMap.containsKey(object)) {
				bw.append(1+"\n");
			}else {
				bw.append(0+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
