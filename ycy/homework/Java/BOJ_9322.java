import java.util.*;
import java.io.*;

public class Main {
/* 철벽보안알고리즘 */
	public static void main(String[] args) throws IOException{
		int testCaseNum=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		testCaseNum=Integer.parseInt(br.readLine());
		for(int i=0; i<testCaseNum; i++) {
			int wordNum = Integer.parseInt(br.readLine());
			//publicKey1 입력받기
			st = new StringTokenizer(br.readLine());
			HashMap<String, Integer> publicKey1 = new HashMap();
			
			for(int j=0; j<wordNum; j++) {
				publicKey1.put(st.nextToken(), j);
			}
			
			//publicKey2 입력받기
			st = new StringTokenizer(br.readLine());
			int keyOrder[] = new int[wordNum];//공개키1이 공개키2로 바뀔때 어떤 인덱스자리로 들어갔는지를 담는다.
			for(int j=0; j<wordNum; j++) {
				keyOrder[j] = (int) publicKey1.get(st.nextToken());
			}
			
			//암호키를 입력받는다.
			st = new StringTokenizer(br.readLine());
			String[] plainText = new String[wordNum];
			for(int j=0; j<wordNum; j++) {
				plainText[keyOrder[j]] = st.nextToken();
			}
			
			//출력
			for(int j=0; j<wordNum; j++) {
				bw.append(plainText[j] + " ");
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
