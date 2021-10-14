package 이진탐색_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class suBinarySearch{
	int start;
	int end;
	int mid;
	int target;
	int arr[]; 
	
	public suBinarySearch(int start, int end, int arr[]) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}
	
	public int targetExist(int target) {
		//start, end는 target에 따라 변하지 않음
		int start1 = this.start;
		int end1 = this.end;
		
		while(start1 <= end1) {
			mid = (start1 + end1)/2;
			if(arr[mid] == target) {
				return 1;
			}else if(arr[mid] < target) {
				start1 = mid + 1;
			}else {
				end1 = mid - 1;
			}
		}
		return 0;
	}
}

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nList = new ArrayList<Integer>();
		int nArr[]; 
		List<Integer> mList = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			nList.add(Integer.parseInt(st.nextToken()));
		}
		//정렬
		nList.sort(Comparator.naturalOrder());
		nArr = new int[n];
		for(int i=0; i<n; i++) {
			nArr[i] = nList.get(i);
		}
		
		int m = Integer.parseInt(br.readLine());//m받기
		st = new StringTokenizer(br.readLine());//m만큼의 숫자 받기
		for(int i=0; i<m; i++) {
			mList.add(Integer.parseInt(st.nextToken()));
		}
		
		//m이 nList에 있으면 0 없으면 1
		suBinarySearch subs = new suBinarySearch(0 , n-1, nArr);
		for(int i=0; i<m; i++) {
			int result = subs.targetExist(mList.get(i));
			System.out.println(result);
		}
	}

}
