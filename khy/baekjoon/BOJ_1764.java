import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
    //듣도못한 & 보도못한 사람 이름과 수를 세는데 도와줄 hm
		HashMap<String, Integer> hm = new HashMap();
    //듣도못한 & 보도못한 사람 list를 담을 arr
		ArrayList<String> arr = new ArrayList();
    //듣도못한 & 보도못한 사람 수를 셀 곳 count
    int count = 0;

		String[] nums = br.readLine().split(" ");
		int sum = Integer.parseInt(nums[0])+ Integer.parseInt(nums[1]);
		for(int i=0; i<sum; i++) {
			String str = br.readLine();
			if(!hm.containsKey(str)) {
				hm.put(str,hm.getOrDefault(str, 0)+1);
			} else {
				hm.put(str, hm.get(str)-1);
				arr.add(str);
				count++;
			}
		}
		sb.append(count).append("\n");
		Collections.sort(arr);
		for(String name : arr) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
		
	}
}
