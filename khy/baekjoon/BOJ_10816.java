import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int N; //가지고 있는 카드의 수
		int[] myCard; //가지고 있는 카드를 담을 배열
		int M; //확인 할 카드의 수
		int[] Mlist; // 확인할 카드를 담을 배열

		N = Integer.parseInt(br.readLine());
		myCard = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			myCard[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		Mlist = new int[M];
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer,Integer> hm = new HashMap();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			hm.put(num,0);
			Mlist[i] = num;
		}
		
		for(int i=0; i<N; i++) {
			if(hm.containsKey(myCard[i])) hm.put(myCard[i], hm.get(myCard[i])+1);
		}
		
		for(int n : Mlist) {
			sb.append(hm.get(n)).append(" ");
		}
		System.out.println(sb);
		
	}
}
