package ars3;

import java.util.Scanner;
public class Homework2 {
	public static void main(String[] args) {
		String in = new Scanner(System.in).nextLine();
		int cal = 0;
		int height =0;
		boolean scarp = false;
		
		for (int i = 0; i < in.length(); i++) {
			if(in.charAt(i)=='(') {
				height++;
				if(scarp) {
					cal += height*2;
				}else {
					cal+=height;
				}
			}
			else if(in.charAt(i)==')') {
				if(scarp) {
					cal += height*2;
				}else {
					cal += height;
				} height--;
			}
			else {
				scarp = ! scarp;
			}
		}
		System.out.println("소모한  칼로리 :" +cal);
		
	}

}
