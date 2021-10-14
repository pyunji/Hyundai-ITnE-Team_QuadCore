package ycy_0924;

import java.io.*;
import java.util.*;

class suBinarySearch{
	int[] arr;
	int start;
	int end;
	int mid;
	//int target;
	
	public suBinarySearch(int[] arr,int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		//this.target = target;
	}
	
	public int fun1(int target) {
		int start1 = start;
		int end1 = end;
		
		while (start1 <= end1) {
			mid = (start1 + end1)/2;
			
			if(arr[mid] == target) {
				return 1;
			}else if(arr[mid] > target){
				end1 = mid-1;
			}else {
				start1 = mid+1;
			}
		}
		
		return 0;
	}
	
}

public class 수찾기_binarySearch {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n,m;
		int[] arrA;
		n = Integer.parseInt(br.readLine());
		arrA = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);
		
		Queue<Integer> input = new LinkedList<Integer>();
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int inputValue = Integer.parseInt(st.nextToken());
			input.offer(inputValue);
		}
		
		suBinarySearch bs=new suBinarySearch(arrA, 0, n-1);
		
		while(!input.isEmpty()) {
			int target = input.poll();
			//System.out.println(target);
			bw.append(bs.fun1(target)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
