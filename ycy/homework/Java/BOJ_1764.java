import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		HashMap<String, Boolean> result = new HashMap();//듣도보도 못한 사람을 담는 HashMap
		int N=0, M=0;
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<String> sortName = new ArrayList<String>();
		
		//입력받기
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			 result.put(br.readLine(), false);
		}
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(result.containsKey(name)) {
				result.replace(name, true);
			}
		}
		
		//sort해서 ArrayList에 넣기
		//HashMap을 Set으로 변환한 뒤 new ArrayList(Set); 을 하면 HashMap의 키 또는 Value가 ArrayList로 변환된다..!
		//HashMap -> Set -> ArrayList
		//sortName = new ArrayList(result.keySet());
		sortName = new ArrayList();
		
		for(String key : result.keySet()) {
			if(result.get(key) == true) {
				sortName.add(key);
			}
		}
		
		sortName.sort(Comparator.naturalOrder());
		bw.append(sortName.size()+"\n");
		for(int i=0; i<sortName.size(); i++) {
			bw.append(sortName.get(i)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
