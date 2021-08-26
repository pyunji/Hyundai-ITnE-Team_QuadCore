import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(br.readLine());
		HashMap<String, Boolean> hm = new HashMap();
		boolean isEnter;
		String key, val;
		ArrayList<String> enterName = new ArrayList();
		
		for(int i=0; i<num;i++) {
			st = new StringTokenizer(br.readLine());
			key = st.nextToken();
			val = st.nextToken();
			isEnter = val.equals("enter") ? true : false;
			hm.put(key, isEnter);
		}
		
		for(String key1 : hm.keySet()) {
			if(hm.get(key1)) {
				enterName.add(key1);
			}
		}
		
		enterName.sort(Comparator.reverseOrder());
		for(int i=0; i<enterName.size(); i++) {
			bw.write(enterName.get(i)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
