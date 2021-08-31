import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> account = new Stack();
		int sum = 0;
		int K = Integer.parseInt(br.readLine());
	
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				account.pop();
			} else {
				account.push(num);
			}
		}
		
		while(!account.isEmpty()) {
			sum += account.pop();
		}
		System.out.println(sum);
	}
}
