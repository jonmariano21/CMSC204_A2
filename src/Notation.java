//import java.util.ArrayList;


public class Notation {
	//private static char[] array;
	private static String inFix = "";
	private static String postFix = "";
	private double evalInfix = 0.00;
	private double evalPostfix = 0.00;
	
	public static MyStack<String> operatorStack = new MyStack<String>(100);
	
	public static String convertInfixToPostfix(String s) throws StackOverflowException, StackUnderflowException {
		//easyPostfix = "54+"
		//easyInfix = "(5+4)"
		
		//intermediateInfix = "((3*(5+4))+2)";
		//intermediatePostfix = "354+*2+";
		
		System.out.println("Inside convertInfixToPostfix - The input Infix = " + s);
	
		char[] array;
		char ch;
		char nextCharacter;
		char topOperator;

		String nextCharString = "";
		String topOperatorString;
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
		        case '( ' :
         operatorStack.push(nextCharacter) 
         break
      case ')' : // Stack is not empty if infix expression is valid 
         topOperator = operatorStack.pop() 
         while (topOperator != '(')
         {
            Append topOperator to postfix
            topOperator = operatorStack.pop()
         } 
         break
      default: 
         break // Ignore unexpected characters
   } 
} 
while (!operatorStack.isEmpty()) 
{
   topOperator = operatorStack.pop()
   Append topOperator to postfix 
} 
return postfix


		*/
		//Get the characters of the string & populate the array
		System.out.println("The length of the infix = " + inFix.length());	
		for(int i = 0; i < inFix.length(); i++) {
			//System.out.println("Char " + i + " is " + inFix.charAt(i));	
			ch = inFix.charAt(i);
			array[i] = ch;
			//System.out.println("array[" + i + "] = " + array[i]);
		}
		
		while(array[index] != ' ') {
			System.out.println("Inside WHILE");
			
			nextCharacter = array[index];
			nextCharString = "" + nextCharacter;
			System.out.println("The nextCharString = " + nextCharString);
				 
			//intermediateInfix = "((3*(5+4))+2)";
			//intermediatePostfix = "354+*2+";
			switch(nextCharacter) {
				case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
					postFix = postFix + nextCharString;
					System.out.println("Theres a number! - postFix = " + postFix);
					break;
				case '^':
					operatorStack.push(nextCharString);
					break;
				case '+' : case '-' : case '*' : case '/' :
					operatorStack.push(nextCharString);
					while (!operatorStack.isEmpty() && (charPrecedence(nextCharString) <  charPrecedence(operatorStack.peek() ) ) ) {
						//postFix = postFix + operatorStack.peek();
						System.out.println("The +-*/ postFix = " + postFix + ", The operatorStack = " + operatorStack);
						operatorStack.pop();
					}
					//operatorStack.push(nextCharString);
					break;
				case '(' :
			         operatorStack.push(nextCharString); 
			         break;
			    case ')' : // Stack is not empty if infix expression is valid 
			         System.out.println("The operatorStack = " + operatorStack);

			         topOperatorString = operatorStack.pop(); 
			         //topOperatorString = operatorStack.peek(); 

			
			         System.out.println("The topOperatorString = " + topOperatorString);
			         //topOperator = topOperatorString.charAt(0);
			         while (!topOperatorString.equals("(")){
			        	System.out.println("In CASE ')' WHILE");
			            postFix = postFix + topOperatorString;
			            System.out.println("The postFix in CASE ) = " + postFix);
		        		topOperatorString = operatorStack.pop();
				        System.out.println("The last topOperatorString = " + topOperatorString);
				     } 
			         if(operatorStack.isEmpty()) {
			        	 return postFix;
			         }
				     System.out.println("CASE ) before break");

			         break;
			    default: 
			         break; // Ignore unexpected characters
			}
		    System.out.println("before index++");

			index++;
		} 
			
	    System.out.println("before WHILE operatorStack is NOT empty");
	 
		while (!operatorStack.isEmpty()) {
			System.out.println("Inside WHILE operatorStack is NOT empty");
			topOperatorString = operatorStack.pop();
			System.out.println("The topOperatorString = " + topOperatorString);
			postFix = postFix + topOperatorString;
			System.out.println("The postFix = " + postFix);

		} 
			
		//index++;
		//return postFix;

					
		
	
		System.out.println("FINAL postFix = " + postFix);
		return postFix;	
		//index++;
		
		//System.out.println("postFix = " + postFix);

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
	        default:
	            i = -1;	
	    }
	    System.out.println("i = " + i);
	    return i;
	}

}
