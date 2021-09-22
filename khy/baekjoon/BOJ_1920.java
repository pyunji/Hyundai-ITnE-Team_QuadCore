import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			check(arr,num);
		}
		System.out.println(sb);
	}
	
	public static void check(int[] arr, int num) {
		int start = 0;
		int end = arr.length-1;
		while(true) {
			if(end<start) break;
			int mid = (start+end)/2;
			
			if(arr[mid]<num) {
				start = mid+1;
			} else if(arr[mid]>num) {
				end = mid-1;
			} else {
				sb.append("1").append("\n");
				return;
			}
		}
		sb.append("0").append("\n");
	}
	
}
