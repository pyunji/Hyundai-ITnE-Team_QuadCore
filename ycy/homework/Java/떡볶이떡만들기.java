package ycy_0914;
import java.util.*;
import java.io.*;
public class binarySearch_dbn {
	public static int binarySearch(int[] arr, int target, int end) {
		int result=0;
		int sum=0;//잘린 떡의 길이
		int start = 1;//떡의 최소 길이
		int mid = 0;//이진 탐색을 위한 값
		
		while(start <= end) {
			sum=0;
			mid = (start + end) / 2;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > mid) {
					sum += arr[i]-mid;
				}
			}
			if(sum == target) { return mid; }
			else if(sum > target) { start = mid +1; result = mid;}
			else { end = mid-1; }
		}
		
		return result;
	}
	
	public static void main() throws Exception{
		int n,m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*떡의 개수 n과 요청한 떡의 길이 m*/
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		/*떡의 길이를 담을 배열*/
		List<Integer> riceArr = new ArrayList<Integer>();
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			riceArr.add(a);
		}
		
		riceArr.sort(Comparator.naturalOrder());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = riceArr.get(i);
		}
		
		int result = binarySearch(arr, m, arr[n-1]);
		System.out.println(result);
	}
}
