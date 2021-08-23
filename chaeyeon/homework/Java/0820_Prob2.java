package prob2_re;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "((#(())#(())))";
		String[] data = input.split("");
		boolean isHigh = false;
		int height=0, kcal=0;
		
		
		
		for(int i=0; i<data.length; i++) {
			if(data[i].equals("#")) {
				isHigh = !isHigh;
			}
			
			if(data[i].equals("(")) {
				height++;
				if(isHigh) {
					kcal += height*2;
				}else {
					kcal += height;
				}
				
			}else if(data[i].equals(")")) {
				
				if(isHigh) {
					kcal+=height*2;
				}else {
					kcal+=height;
				}
				height--;
			}
		}
		
		System.out.println("칼로리 : " + kcal);
		
	}

}
