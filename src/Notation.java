//import java.util.ArrayList;


public class Notation {
	private static char[] array;
	private static String inFix = "";
	private static String postFix = "";
	private double evalInfix = 0.00;
	private double evalPostfix = 0.00;
	
	public static MyStack<String> operatorStack = new MyStack<String>(100);
	
	public static String convertInfixToPostfix(String s) throws StackOverflowException, StackUnderflowException {
		//easyPostfix = "54+"
		//easyInfix = "(5+4)"
		System.out.println("Inside convertInfixToPostfix - The input Infix = " + s);
	
		char ch;
		char nextCharacter;
		String nextCharString = "";
		int index = 0;
		inFix = s;
		//array = (char[]) new Object[inFix.length()];
		array = new char[inFix.length()];


		/*
		// Converts an infix expression to an equivalent postfix expression.
		operatorStack = a new empty stack 
		postfix = a new empty string
		while (infix has characters left to parse) 
		{ 
		   nextCharacter = next nonblank character of infix
		   switch (nextCharacter) 
		   {
		      case variable:
		         Append nextCharacter to postfix 
		         break
		      case '^' :
		         operatorStack.push(nextCharacter) 
		         break
		      case '+' : case '-' : case '*' : case '/' :
		         while (!operatorStack.isEmpty() and
			   precedence of nextCharacter <= precedence of operatorStack.peek()) 
		         {
		            Append operatorStack.peek() to postfix
		            operatorStack.pop() 
		         } 
		        operatorStack.push(nextCharacter) 
		        break

		*/
		//Get the characters of the string & populate the array
		System.out.println("The length of the infix = " + inFix.length());	
		for(int i = 0; i < inFix.length(); i++) {
			System.out.println("Char " + i + " is " + inFix.charAt(i));	
			ch = inFix.charAt(i);
			array[i] = ch;
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
		while(array[index] != ' ') {
			System.out.println("Inside WHILE");
			nextCharacter = array[index + 1];
			System.out.println("nextCharacter = " + nextCharacter);
			nextCharString = "" + nextCharacter;
			System.out.println("nextCharString = " + nextCharString);

			
			switch(nextCharacter) {
				case '1':
					postFix = postFix + nextCharString;
					break;
				case '^':
					operatorStack.push(nextCharString);
					break;
				case '+' : case '-' : case '*' : case '/' :
					while (!operatorStack.isEmpty() ) {//&& charPrecedence(nextCharString) <=  operatorStack.peek() )
						postFix = postFix + operatorStack.peek();
						operatorStack.pop();
					}
				operatorStack.push(nextCharString);
				break;
					
			}
			
			index++;
		
			System.out.println("postFix = " + postFix);

		}
		//System.out.println("postFix = " + postFix);
		return postFix;
		
		//String dummy = "";
		//return dummy;
		
	}
	
	public static String convertPostfixToInfix(String s) {
		//easyPostfix = "54+"
		//easyInfix = "(5+4)"
		System.out.println("Inside convertPostfixToInfix - The input Postfix = " + s);
		
		String dummy = "";
		return dummy;
		
	}
	
	public static double evaluatePostfixExpression(String s) {
		
		double dummy = 0.00;
		return dummy;
		
	}
	
	public static double evaluateInfixExpression(String s) {
		
		double dummy = 0.00;
		return dummy;
		
	}
	
	
	public static int charPrecedence(String c) {
	    int i = -1;
	    switch (c) {
	        case "+":
	        case "-":
	            i = 0;
	        case "*":
	        case "/":
	            i = 1;
	        case "^":
	            i = 2;
	    }
	    System.out.println("i = " + i);
	    return i;
	}

}
