import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		//가지고 있는 랜선의 개수
		int K = Integer.parseInt(str[0]);
		//필요한 랜선의 개수
		int N = Integer.parseInt(str[1]);
		
		//랜선들의 길이를 담을 배열
		long[] arr = new long[K];
		
		long start = 1;
		long end = Integer.MIN_VALUE;
		
		//for문으로 K번 만큼 돌면서 arr에 랜선의 길이를 담는다.
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if(arr[i]>end) {
				end = arr[i];
			}
		}
		
		//왜 최대값으로 길이가 가장 긴 것을 설정했나?
		// => 1개가 필요하다면 가장 긴것 자체가 정답이기 때문
		// => 구하고자 하는 랜선의 길이는 가장 짧은 것과 가장 긴것의 사이 값일 것이기 때문에
		
		
		long mid = 0;
		
		while(start <= end) {
			mid = (start+end)/2;
			int count = 0;
			for(int i=0; i<K; i++) {
				count += arr[i]/mid;
			}
			if(count < N) {
				end = mid-1;
			} else if(count >= N) {
				start = mid+1;
			}
		}
		System.out.println(start-1);
		
		
	}
}
