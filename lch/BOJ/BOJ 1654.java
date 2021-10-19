package sec02.exam01_createthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		long[] arr = new long[k];
		
		long start = 1;
		long end = Integer.MIN_VALUE;
		for(int i=0; i<k; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if(arr[i]>end) {
				end = arr[i];
			}
		}
		long mid = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			int count = 0;
			for(int i=0; i<k; i++) {
				count += arr[i]/mid;
			}
			if(count < n) {
				end = mid-1;
			} else if(count >= n) {
				start = mid+1;
			}
		}
		System.out.println(start-1);
		
	}
}