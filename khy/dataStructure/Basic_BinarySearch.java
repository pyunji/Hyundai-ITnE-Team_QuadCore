import java.util.Arrays;

public class MyBinarySearch {
	public static void main(String[] args) {
		int[] arr = {0,2,4,6,8,10,12,14,16,18};
		int target = 3;
		int start = 0;
		int end = arr.length-1;
		Arrays.sort(arr);
		
		System.out.println(binarySearch(arr,target,start,end));
		
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		while(start<end) {
			int mid = (start+end)/2;
			if(arr[mid] == target) return mid;
			else if(arr[mid]<target) start = mid+1;
			else if(arr[mid]>target) end = mid-1;
		}
		return -1;
	}
}
