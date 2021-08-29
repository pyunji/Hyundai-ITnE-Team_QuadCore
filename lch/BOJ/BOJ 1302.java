import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String maxStr = "";
		int max = Integer.MIN_VALUE;
		HashMap<String,Integer> map = new HashMap();

		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map.put(str,map.getOrDefault(str, 0)+1);
		}

		for(String str : map.keySet()) {
			if(map.get(str)>max) {
				max =map.get(str);
				maxStr = str;
			}else if(map.get(str)==max) {
				if(maxStr.compareTo(str)<0) {
					continue;
				}else {
					max = map.get(str);
					maxStr = str;
				}
			}
		}
		System.out.println(maxStr);
	}
}
