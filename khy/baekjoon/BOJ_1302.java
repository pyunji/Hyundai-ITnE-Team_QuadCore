import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String maxStr = "";
		int max = Integer.MIN_VALUE;
		HashMap<String,Integer> hm = new HashMap();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			hm.put(str,hm.getOrDefault(str, 0)+1);
		}
		
		for(String str : hm.keySet()) {
			if(hm.get(str)>max) {
				max = hm.get(str);
				maxStr = str;
			}else if(hm.get(str)==max) {
				if(maxStr.compareTo(str)<0) {
					continue;
				}else {
					max = hm.get(str);
					maxStr = str;
				}
			}
		}
		System.out.println(maxStr);
	}
}
