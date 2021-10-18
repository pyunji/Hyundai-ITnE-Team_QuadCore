package test;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class suBinarySearch{
	//int[] arr : nArr
	//start : 배열의 시작 인덱스 (0)
	//end : 배열의 끝 인덱스 : m-1;
	//target : 각각의 m
	public int binarySearch(int[] arr, int start, int end, int target) {
		int mid;
		
		while (start <= end) {
			mid = (start + end)/2;
			
			if(arr[mid] == target) {
				return 1;
			}else if(arr[mid] > target){
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return 0;
	}
	
}

//수찾기
//n과 n개의 수 m과 m개의 수를 받은 뒤 
//n개의 수에 각각의 m이 존재하면 1, 존재하지 않으면 0 출력한다.
public class Main {
	
	public static void main(String[] args) throws Exception{
		int n,m;
		int[] nArr;
		int[] mArr;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//n과 숫자들 받은 후 오름차순정렬
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nArr = new int[n];
		for(int i=0; i<n;i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArr);
		
		//m과 숫자들 받기
		m = Integer.parseInt(br.readLine());
		mArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m;i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		suBinarySearch sbs = new suBinarySearch();
		//같은 수가 있는지 찾기
		for(int i=0; i<m; i++) {
			 bw.append(sbs.binarySearch(nArr, 0, m-1, mArr[i])+" ");
		}
		bw.flush();
	}

}
