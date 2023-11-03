import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Driver {
	
	
	public static int countExpressions(Scanner sc) {
		int counter = 0; 
		while(sc.hasNextLine()) {
			counter++;
		}
		return counter; 
	}
	
	public static String[] readFile(Scanner sc, int num) {
		String[] expressions = new String[num];
		for(int i = 0 ; i < num ; i++) {
			expressions[i] = sc.nextLine();
		}
		return expressions;
	}
	
	public static void main(String[] args) {
	
		String[] equation = new String[20];
		
		equation[0] = "14≤4-3*2+7$";
		equation[1] = "24-32≤7$";
		equation[2] = "2^2$";
		equation[3] = "5+(6*2)$";
		equation[4] = "5+(6^2)*2$";
		equation[5] = "50+89+6*2$";
		equation[6] = "100/5*2+90$";
		equation[7] = "5+123-20$";
		equation[8] = "90≤100-6*2$";
		equation[9] = "8^2+(6*2)$";
		equation[10] = "13+450-50/5$";
		equation[11] = "(90+22)+95>100$";
		equation[12] = "90-30+20$";
		equation[13] = "80+50+(90-5)=10$";
		equation[14] = "30+36/6*2$";
		equation[15] = "5+10≥20$";
		equation[16] = "59+34-20≤30$";
		equation[17] = "80-6*2$";
		equation[18] = "15+5*(2+5)$";
		equation[19] = "10+6*2+3$";
		
		int equationResult = 0;
		//declaring a variable
		long sum = 0;
		//declaring a variable
		long time = 0;
		
		//the method is execute for input values that are multiple of 5
		for(int i = 0 ; i < equation.length ; i++) { 
			System.out.println(equation[i]);
			//calculating start time
			long startTime = System.nanoTime();
			//Calling BinaryFib
			ArithmeticCalculator.calculator(equation[i]);
			//Calculating endtime
			long endTime = System.nanoTime();
			time = endTime-startTime;
			System.out.println("The runtime is for the expression is " + time + "\n");
		}
		
		
		

	}

}
