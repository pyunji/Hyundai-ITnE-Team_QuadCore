package problem;

import java.io.*;
import java.util.*;

public class Pro2_210820 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mountain = br.readLine();
		int kcalSum = 0; //총 kcal
		int curHeight = 0; //현재높이
		boolean scarp = false; //경사
		
		for(int i=0; i<mountain.length(); i++) {
			char next = mountain.charAt(i);
			// '(' 인경우 = 올라가는경우
			if(next=='(') {	
				curHeight++;
				// 경사가 급한 곳을 올라가는경우
				if(scarp) {	
					kcalSum += curHeight*2;
				// 경사가 완만한 곳을 올라가는 경우
				}else {	
					kcalSum += curHeight;
				}
			// ')' 인경우 = 내려가는 경우
			} else if(next==')'){ 
				// 경사가 급한 곳을 내려가는경우
				if(scarp) {
					kcalSum += curHeight*2;
				// 경사가 완만한 곳을 내려가는경우
				}else {
					kcalSum += curHeight;
				}
				curHeight--;
			} else { //'#'인경우 = 경사가 바뀌는경우
				scarp = scarp?false:true;
			}
		}
		
		System.out.println(kcalSum);
	
	
	}
}
