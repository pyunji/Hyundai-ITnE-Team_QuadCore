package 이진탐색_떡볶이떡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class BinarySearch{
	int start=0;
	int end;
	int mid;
	int target;
	int[] array;
	
	public BinarySearch(int start, int end, int target, int[] array) {
		this.start = start;
		this.end = end;
		this.target = target;
		this.array = array;
	}
	
	public int bscode() {
		while(start <= end) {
			mid = (start + end)/2;
			int result = 0;
			for(int j=0; j<array.length;j++) {
				if(array[j] > mid) {
					result += (array[j] - mid);
				}
			}
			
			if(result == target) {
				return mid;
			}else if(result < target) {
				end = mid - 1;
			}else if(result > target) {
				start = mid + 1;
			}
		}
		
		return mid;
	}
}

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = 0, m = 0;
		int maxLen;
		int[] array;
		
		while (st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());//떡의 개수
			m = Integer.parseInt(st.nextToken());//요청한 떡의 길이
		}
		
		List<Integer> dduckArray =  new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			dduckArray.add(Integer.parseInt(st.nextToken()));//떡의 길이
		}
		dduckArray.sort(Comparator.naturalOrder());
		maxLen = dduckArray.get(n-1);
		array = new int[n];
		for(int i=0; i<n;i++) {
			array[i] = dduckArray.get(i);
			System.out.println(array[i]);
		}
		
		BinarySearch bs = new BinarySearch(1, maxLen, m, array);
		int result = bs.bscode();
		System.out.println("결과"+result);
	}
	
}
