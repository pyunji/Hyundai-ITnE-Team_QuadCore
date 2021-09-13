import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> lArray = new ArrayList();//랜선 담는 배열 
		
		long max;//나누는 숫자의 최대값
		long min=1;//나누는 숫자의 최소값
		long middle=0;//이분 탐색을 위한 값(max+min)/2
		
		for(int i=0; i<k; i++) {
			lArray.add(Integer.parseInt(br.readLine()));
		}
		lArray.sort(Comparator.naturalOrder());
		max = lArray.get(lArray.size()-1);
		
		while(max >= min) {//이분탐색
			middle = (max+min)/2;
			long curLanSize=0;
			for(int i=0; i<lArray.size(); i++) {
				curLanSize += lArray.get(i)/middle;
			}
			
			if(curLanSize >= n) {
				min = middle+1;
			} else /*if(curLanSize < n) */{
				max = middle-1;
			}
			
		}
		System.out.println(max);
		//bw.write(max);
		//bw.flush();
		//bw.close();
		br.close();
	}

}
