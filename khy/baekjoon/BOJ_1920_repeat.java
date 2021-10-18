import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//자연수 N
		int N = Integer.parseInt(br.readLine());
		//N개의 정수
		String[] strArr1 = br.readLine().split(" ");
		
		//N개의 수를 숫자 배열에 담기
		int[] numArr1 = new int[N];
		for(int i=0; i<N; i++) {
			numArr1[i] = Integer.parseInt(strArr1[i]);
		}
		
		//N개의 수 배열을 오름차순 정렬
		Arrays.sort(numArr1);
		
		//자연수 M
		int M = Integer.parseInt(br.readLine());
		
		//M개의 수
		String[] strArr2 = br.readLine().split(" ");
		
		
		//M개의 숫자중 하나와 N개의 숫자배열과 비교
		for(int i=0; i<M; i++) {
			int curNum = Integer.parseInt(strArr2[i]);
			int result = findNum(curNum, numArr1);
			System.out.println(result);
		}
	}
	
	public static int findNum(int number, int[] array) {
		
		int start = 0;
		int end = array.length-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(array[mid] == number) {
				return 1;
			} else if(array[mid] > number) {
				end = mid-1;
			} else if(array[mid] < number) {
				start = mid+1;
			}
		}
		return 0;
	}
}
