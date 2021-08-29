import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		HashSet<String> hset = new HashSet<String>();	
		for(int i=0; i<N; i++)	
			hset.add(bf.readLine());	
		
    List<String> list = new ArrayList<String>();
		for(int i=0; i<M; i++) {
			String str = bf.readLine();
			if(hset.contains(str)) 	list.add(str);
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		bf.close();
	}
  
}
