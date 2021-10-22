import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		
		int m =Integer.parseInt(br.readLine());
		String[] str2 = br.readLine().split(" ");
		
		for(int i=0; i<m; i++) {
			int start =0;
			int end = n-1;
			int mid;
			int target = Integer.parseInt(str2[i]);
			int result =0;
			while(start <= end) {
				mid = (start + end)/2;
				if(arr[mid] < target) {
					start = mid +1;
				} else if(arr[mid] > target) {
					end= mid -1;
				} else {
					result =1;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
