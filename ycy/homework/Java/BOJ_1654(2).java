package 랜선자르기;

import java.util.*;
import java.io.*;

class LanBinarySearch{
	long start=0;
	long end=0;
	long mid=0;
	int target=0;
	int[] arr;
	long originResult=0;
	
	public LanBinarySearch(int start, int end, int target, int[] arr) {
		this.start = start;
		this.end = end; 
		this.target = target;
		this.arr = arr;
	}
	
	//최대 랜선의 길이 출력
	public long binarySearch() {
		while(start <= end) {
			mid = (start+end)/2;
			int result=0;
			for(int item : arr) {
				result += item/mid;
			}
			
			if(result >= target) {
				start = mid + 1; 
				originResult = mid;//현재의 최대 길이
			}else {
				end = mid-1;
			}
		}
		
		return originResult;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		int k=0, n=0;//가지고있는 랜선 : k, 필요한 랜선 개수 : n
		List<Integer> lanList = new ArrayList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
				
		//k개의 선의 길이 입력받기
		for(int i=0; i<k; i++) {
			lanList.add(Integer.parseInt(br.readLine()));
		}
		//sort
		lanList.sort(Comparator.naturalOrder());
		//제일 긴 길이
		int Lan = lanList.get(k-1);
		
		//배열 만들기
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = lanList.get(i);
		}
		
		/* start 1
		 * end sortestLan
		 * mid 
		 * target 선의 개수(n)보다 크거나 같아야한다.*/
		LanBinarySearch lanBinarySearch = new LanBinarySearch(1, Lan, n, arr);
		System.out.println(lanBinarySearch.binarySearch());
		
		br.close();
	}
}
