import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<num; i++) {
			int data = Integer.parseInt(br.readLine());
			if(data == 0) {
				stack.pop();
			}else {
				stack.push(data);
			}
		}
		
		int sum=0;
		while(!stack.empty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}

}