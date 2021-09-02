import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			function();
		}
		System.out.println(sb);
	}
	
	public static void function() throws IOException{
		String Strarr = br.readLine();
		int count = 0;
		for(int i=0; i<Strarr.length();i++) {
			if(Strarr.charAt(i)=='(') count++;
			else count--;
			if(count<0) {
				break;
			}
		}
		if(count==0) {
			sb.append("YES").append("\n");
		}else {
			sb.append("NO").append("\n");
		}
	}
	
}
