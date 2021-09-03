package ycy_0902;

import java.io.*;
import java.util.*;

public class BOJ_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loopN = Integer.parseInt(br.readLine());
		
		for(int i=0; i<loopN; i++) {
			String input = br.readLine();//괄호 문자열을 담음..
			boolean result = ps(input);
			
			if(result) { bw.append("YES\n"); }
			else { bw.append("NO\n"); }
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static boolean ps(String input){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			
			if(stack.empty()) {
				if(ch=='(') {stack.push(ch);}
				else if(ch == ')') {return false;}
			}else if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')'){
				stack.pop();
			}
		}
		
		return stack.empty() ? true: false;
	}

}
