import java.io.*;
import java.util.*;

public class Main {
	
	static Long Max = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		str = br.readLine();
		st = new StringTokenizer(str);
		for(int i=0; i<N; i++) {
			long lengthOfRiceCake = Long.parseLong(st.nextToken()); 
			arr[i] = lengthOfRiceCake;
			if(lengthOfRiceCake>Max) {
				Max = lengthOfRiceCake;
			}
		}
		
		//시작 길이 = 0;
		//끝 길이 = 떡중 가장 긴 길이
		long start = 0;
		long end = Max;
		long mid = 0;
		
		while(true) {
			mid = (int)((start+end)/2);
			long result = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]/mid >=1) {
					result += (int)(arr[i]%mid);
				}
			}
			if(result == M) {
				break;
			} else if(result>M){
				start = mid+1;
			} else if(result<M){
				end = mid-1;
			}
		}
		
		System.out.println(mid);
	}
}
