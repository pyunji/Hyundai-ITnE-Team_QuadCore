package ycy_0914;

import java.util.Scanner;

class BinarySearch1{
	int[] arr;
	int target;
	int start;
	int end;
	
	public BinarySearch1(int[] arr, int target, int start, int end) {
		this.arr = arr;
		this.target = target;
		this.start = start;
		this.end = end;
	}
	
	public int fun1() {
		
		while(start <= end) {
			
			int mid = (start + end)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {//target이 더 작으면 작은쪽 탐색
				end = mid-1;
			}else {
				start = mid +1;
			}
		}
		
		return -1;
	}
}


public class BinarySearch {
	
	public static void main(String[] args) {
		//배열 수 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//target 입력
		int target = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {//배열에는 0-i의 수를 넣는다.
			arr[i] = i;
		}
		
		BinarySearch1 bs = new BinarySearch1(arr, target, 0, n);
		int result = bs.fun1();
		if(result == -1) {
			System.out.println("값이 존재하지 않습니다.");
		}else {
			System.out.println((result+1)+"번째에 값이 존재합니다.");
		}
		
	}

}
