import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		int[] card = new int[20000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			++card[Integer.parseInt(st.nextToken())+10000000];
		}
		
		M=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			bw.append(card[Integer.parseInt(st.nextToken())+10000000]+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
