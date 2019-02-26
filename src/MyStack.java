/*
 * CMSC 204 Assignment 2
 * Class: MyStack
 * 
 * @author Jonathan Mariano
 * 
 * Description: MyStack will implement the StackInterface. 
 */

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	
	private T[] genericStackArray; //Generic Array
	private int sizeOfStack; //Size of Stack
	private int numStackElements; //Number of elements on Stack
	private int top;
	private int bottom;
	
	

	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 * @return 
	 */
	
	//1
	/*
	 * MyStack
	 * @param Integer that is the size of the Stack
	 */
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		sizeOfStack = size;
		top = -1;
		genericStackArray = (T[]) new Object[sizeOfStack];
		
	}
	
	//2 - Default Constructor
	public void myStack() {
		sizeOfStack = 5;
		top = -1;
		genericStackArray = (T[]) new Object[sizeOfStack];

	}
	
	/**
	 * isEmpty
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		else {
			return false;
		}
		//boolean dummy = true;
		//return dummy;
	}

	/**
	 * isFull
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		System.out.println("The sizeOfStack = " + sizeOfStack);
		System.out.println("The numStackElements = " + numStackElements);

		if(sizeOfStack == numStackElements) {
			return true;
		}
		else {
			return false;
		}
		
		//boolean dummy = true;
		//return dummy;
	}
	

	/**
	 * pop
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException{
		//System.out.println("The top = " + top);
		int topIndex; //Top is the end of the array list
		
		if(top == -1) {
			//System.out.println("The stack is empty there is nothing to POP! Throw StackUnderflowException");
			throw new StackUnderflowException();
		}
		else {
			topIndex = top;
			top--; //Decrement the top of the stack
			System.out.println("genericStackArray[" + topIndex + "] = " + genericStackArray[topIndex]);
			numStackElements--; //Decrement the number of stack elements
			return genericStackArray[topIndex];
		}
	}
	
	/**
	 * peek
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	//When peeking, no need to decrement the number of stack elements like in pop() b/c we just want to see what the top is.
	public T peek() throws StackUnderflowException{
		//System.out.println("Lets PEEK at the top of the stack which is: " + top);
		
		if(top == -1) {
			throw new StackUnderflowException();
		}
		else {
			System.out.println("Inside PEEK, genericStackArray[" + top + "] = " + genericStackArray[top]);
			
			return genericStackArray[top];
		}

		
	}

	/**
	 * size
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		System.out.println("Inside size() - The numStackElements = " + numStackElements);
		return numStackElements;
		//int dummy = 0;
		//return dummy;
	}
	
	/**
	 * push
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) throws StackOverflowException{
		
		if( top == (sizeOfStack - 1) ) {
			System.out.println("The top of the stack is MAXED");
			throw new StackOverflowException();
		}
		else {
			top++;
			genericStackArray[top] = e;
			numStackElements++; //Increment the number of stack elements
			return true;
		}
		
		//boolean dummy = true;
		//return dummy;
		
	}
	
	
	/**
	 * toString
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		System.out.println("The genericStackArray = " + genericStackArray);
		String elementsInStack = "";
		
		for(T s : genericStackArray) {
			if(s != null) {
				elementsInStack = elementsInStack + s;
				System.out.println("elementsInStack = " + elementsInStack);
			}
		}
		return elementsInStack;
		
		//String dummy = "";
		//return dummy;
	}
	
	/**
	 * toString - Delimiter
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * 
	 * @param String to be placed in between elements of the Stack
	 * 
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String elementsDelimiterInStack = "";
		
		for(T s : genericStackArray) {
			if(s != null ) {
				if(elementsDelimiterInStack == "") {
					System.out.println("s = " + s);
					elementsDelimiterInStack = elementsDelimiterInStack + s;
				}
				else {
					System.out.println("s = " + delimiter + s);
					elementsDelimiterInStack = elementsDelimiterInStack + delimiter + s;

				}
			}
			
			
		}
		
		System.out.println("elementsDelimiterInStack = " + elementsDelimiterInStack);

		return elementsDelimiterInStack;
		//String dummy = "";
		//return dummy;
	}
	
	 /**
	  * fill
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException{
		System.out.println("The list = " + list + " and its size = " + list.size());
		System.out.println("The numStackElements = " + numStackElements);
		System.out.println("The sizeOfStack = " + sizeOfStack);

		int tempTop = 0;
		
		if( list.size() > sizeOfStack) {
			System.out.println("Entry list is greater than the size of the queue");
			throw new StackOverflowException();
		}
		else {
			for(T s : list) {
				System.out.println("The tempTop = " + tempTop + " , s = " + s);
				genericStackArray[tempTop] = s;
				System.out.println("generticStackArray[" + tempTop + "] = " + genericStackArray[tempTop]);
				top = tempTop;
				tempTop++;
				numStackElements++;
			}
			

		}
	}

}
