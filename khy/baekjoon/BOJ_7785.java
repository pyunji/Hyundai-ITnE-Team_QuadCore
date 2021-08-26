import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Integer> check = new HashMap();
		ArrayList<String> names = new ArrayList();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String enterOrLeave = st.nextToken();
			if(enterOrLeave.equals("enter")) check.put(name, check.getOrDefault(name, 0)+1);
			else check.put(name, check.getOrDefault(name, 0)-1);
		}
		
		for(String name : check.keySet()) {
			if(check.get(name) != 0) {
				names.add(name);
			}
		}
		
		Collections.sort(names, (str1, str2)->{
			return -(str1.compareTo(str2));
		});
		
		for(String name :names) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
