
public class ArithmeticCalculator {
	
	public static int assignPriority(char operator) {
		switch(operator) {
			case '+':
				return 3;
			case '-':
				return 3;
			case '*':
				return 4;
			case '/':
				return 4;
			case '^':
				return 5;
			case '<':
				return 2;
			case '>':
				return 2;
			case '≥':
				return 2;
			case '≤':
				return 2;
		}
		return 1;
	}
	
	public static int performOperation(int a, int b, char operator) {
	    switch (operator) {
	      case '+':
	        return a + b;
	      case '-':
	        return a - b;
	      case '*':
	        return a * b;
	      case '/':
	        return a / b;
	      case '^':
	        return (int) Math.pow(a, b);
	      case '<':
	    	 if(a < b) {
	    		 return 1; 
	    	 }
	    	 return 0; 
	        
	      case '>':
	    	  if(a > b) {
	    		  return 1; 
	    	  }
		      return 0; 
	      case '≤':
	    	  if(a <= b) {
	    		  return 1; 
	    	  }
		      return 0; 
	      case '≥':
	    	  if(a >= b) {
	    		  return 1; 
	    	  }
		      return 0;   
	      case '=':
	    	  if(a == b) {
	    		  return 1; 
	    	  }
		      return 0;  
	      case '!':
	    	  if(a != b) {
	    		  return 1; 
	    	  }
		      return 0;
	    }
	    return 0;
	}
	
	public static boolean isDigit(char number) {
		if(number=='0' || number=='1' || number=='2' || number=='3' || number=='4' || number=='5' || number=='6' || 
				number=='7' || number=='8' || number=='9') {
			return true;
		}
		return false;
	}
	
	public static boolean isOperator(char c) {
	    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '<' || c == '>' || c == '≥' || c == '≤' ||
	    		c == '=' || c == '!') {
	    	return true;
	    }
		return false; 
	 }
	
	
	
	public static int calculator(String expression) {
		
		char[] expressionChar = expression.toCharArray();
		StackArray<Integer> operandStack = new StackArray<>();
		StackArray<Character> operatorStack = new StackArray<>();
		
//		Placing all the operators and operands in the stack
		for(int i = 0; i < expression.length(); i++) { //O(n)
			
			String temp = ""; 
			int index = 0; 
			
			if(i <= expression.length()-2) { //O(1)
				//new code starts here
				if(expressionChar[i] == '(') {  //O(1)
					operatorStack.push(expressionChar[i]);
					
					while(expressionChar[i] != ')') { //O(n)
						temp = "";
						index = 0;
						
						if(isDigit(expressionChar[i])) {
							temp=temp+expressionChar[i]; 
							index = i + 1;
							while(isDigit(expressionChar[index])) { //O(n)
								temp = temp + expressionChar[index]; 
								index++;
								i++;
							}
							int numToPush = Integer.parseInt(temp);
							operandStack.push(numToPush);
//							operandStack.display();
//							operatorStack.display();
//							System.out.println();
						}
						else if (isOperator(expressionChar[i])) {
							if(operatorStack.isEmpty()) {
								operatorStack.push(expressionChar[i]);
							}
							else {
								int priority1 = assignPriority(operatorStack.top());
								int priority2 = assignPriority(expressionChar[i]); 
								char operator = ' ';
								int num1 = 0;
								int num2 = 0;
								while(priority1 >= priority2) { //O(n)
									operator = operatorStack.pop();
									num1 = operandStack.pop();
									num2 = operandStack.pop();
									int result = performOperation(num2, num1, operator);
									operandStack.push(result);
									if(!operatorStack.isEmpty()) {
										priority1 = assignPriority(operatorStack.top());
									}
									else {
										operatorStack.push(expressionChar[i]); 
										break;
									}
								}
							    if(priority1 < priority2) {
									operator = expressionChar[i];
									operatorStack.push(operator);
							    }
							}
					   }
					   i++;
					}
					while(operatorStack.top() != '(') { //O(n)
						char operator = operatorStack.pop();
						int num1 = operandStack.pop();
						int num2 = operandStack.pop();
						int result = performOperation(num2, num1, operator);
						operandStack.push(result);
//						operandStack.display();
//						operatorStack.display();
//						System.out.println();
					}
					operatorStack.pop();
//					System.out.println(i);
				}
				
				
				//og code start here
				if(isDigit(expressionChar[i])) {
					temp=temp+expressionChar[i]; 
					index = i + 1;
					while(isDigit(expressionChar[index])) { //O(n)
						temp = temp + expressionChar[index]; 
						index++;
						i++;
					}
					int numToPush = Integer.parseInt(temp);
					operandStack.push(numToPush);
//					operandStack.display();
//					operatorStack.display();
//					System.out.println();

				}
				else if (isOperator(expressionChar[i])) {
					if(operatorStack.isEmpty()) {
						operatorStack.push(expressionChar[i]);
					}
					
					else {
						int priority1 = assignPriority(operatorStack.top());
						int priority2 = assignPriority(expressionChar[i]); 
						char operator = ' ';
						int num1 = 0;
						int num2 = 0;
						while(priority1 >= priority2) { //O(n)
							operator = operatorStack.pop();
							num1 = operandStack.pop();
							num2 = operandStack.pop();
							int result = performOperation(num2, num1, operator);
							operandStack.push(result);
							if(!operatorStack.isEmpty()) {
								priority1 = assignPriority(operatorStack.top());
							}
							else {
								operatorStack.push(expressionChar[i]); 
								break;
							}
					   }
					   if(priority1 < priority2) {
							operator = expressionChar[i];
							operatorStack.push(operator);
					   }
					}
//					operandStack.display();
//					operatorStack.display();
			   }
			}
			else {
				System.out.println("We now have both stacks in the right order");
				break;
			}
		}
	
//		Performing the operations going down both stacks
		while(!operatorStack.isEmpty()) { //O(n)
			char operator = operatorStack.pop();
			int num1 = operandStack.pop();
			int num2 = operandStack.pop();
			int result = performOperation(num2, num1, operator);
			operandStack.push(result);
//			operandStack.display();
//			operatorStack.display();
//			System.out.println();
		}
		int answer = operandStack.top();
		System.out.println("the result for the expression " + expression + " is " + answer);
		return answer;
	}
		
	
}



