import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap();//제목, 개수
		int num = 0;
		int max = 0;
		String maxBook = "";
		num = Integer.parseInt(br.readLine());
		
		//값 넣기
		for(int i=0; i<num; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0)+1);
		}
		
		// HashMap을 돌며 value가 최대값인 책을 찾음
        // 만약 value가 같다면 책이 사전순으로 앞서는 것을 출력
        for(String key : map.keySet()) {
            int value = map.get(key);//책의 수를 넣는다.
 
            //string을 비교하는 compareTo 메서드는 사전순서로 maxBook이 key보다 앞에오는 경우 음수, 아닌경우 양수 반환
            if(max == value && maxBook.compareTo(key) > 0) {
                maxBook = key;
                max = value;
            } else if(max < value) {
                maxBook = key;
                max = value;
            }      
        }
 
        System.out.println(maxBook);

	}

}