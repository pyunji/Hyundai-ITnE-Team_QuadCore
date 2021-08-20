import java.util.Scanner;

/*
int position: 현재의 위치를 나타내는 변수
boolean steep: 급경사 여부
 */
public class Problem2 {
    public static void main(String[] args) {
//        String contour = "((#(())#(())))";
        Scanner scanner = new Scanner(System.in);

        int position = 0;
        int cal = 0;
        boolean isSteep = false;
        String[] steps = scanner.next().split("");
        for (String step : steps) {
            if(step.equals("#")) {
                isSteep = !isSteep;
                continue;
            }


            if (step.equals("(")) {
                position++;
                if (isSteep) cal += 2 * position;
                else cal += position;
            } else {
                if (isSteep) cal += 2 * position;
                else cal += position;
                position--;
            }
        }
        System.out.println("cal = " + cal);
    }
}