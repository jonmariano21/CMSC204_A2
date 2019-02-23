import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private T[] genericArray; //Generic Array
	private int sizeOfQueue; //Size of Queue
	private int numElements; //Number of elements in queue
	private int front;
	private int end;
	
	
	
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */
	//1:
	@SuppressWarnings("unchecked")
	public MyQueue (int i){
		sizeOfQueue = i;
		numElements = 0;
		front = 0;
		end = 0;
		genericArray = (T[]) new Object[sizeOfQueue];
	}
	
	//2: DEFAULT Constructor
	public MyQueue () {
		sizeOfQueue = 5;
		numElements = 0; //Initially empty
		front = 0; //Initially front & end are the same
		end = 0; //Initially front & end are the same
		genericArray = (T[]) new Object[sizeOfQueue];

	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		
		if(numElements == 0) {
			return true;
		} 
		else {
			return false;
		}
		
		//boolean dummy = true;
		
		//return dummy;
		
	}

	/**
	 * Determines if the Queue is empty
	 * @return
	 */
	public boolean isFull() {
		
		if(numElements == sizeOfQueue) {
			return true;
		} 
		else {
			return false;
		}
		
		//boolean dummy = true;
		
		//return dummy;
		
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException{
		System.out.println("\n Inside DEQUEUE");
		int frontIndex;
		int newFront; //New Front place holder
		
		if(numElements == 0) {
			System.out.println("The Queue is empty so nothing to DEQUEUE! \n");
			throw new QueueUnderflowException();
			
		}
		else {
			frontIndex = front;
			System.out.println("The frontIndex = " + frontIndex);
			newFront = front + 1;
			front = newFront % sizeOfQueue; //Will give the new front index of the Queue after front is dequeued
			numElements = numElements - 1; //Decrement the number of elements in the Queue after removing front index
			System.out.println("The front of the queue = " + genericArray[frontIndex]);
			return genericArray[frontIndex];
		}
		
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		System.out.println("Inside size() - The size = " + numElements);
		return numElements;
		
		//int dummy = 0;
		
		//return dummy;
		
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) throws QueueOverflowException{
		T addToEnd = e;
		int newEnd;
		
		if(numElements == sizeOfQueue) {
			System.out.println("The Queue is empty so nothing to ENQUEUE! \n");
			throw new QueueOverflowException();
		}
		else {
			genericArray[end] = addToEnd;
			newEnd = end + 1;
			end = newEnd % sizeOfQueue; //Will give the new end of the Queue
			numElements = numElements + 1; //Increment the number of elements in Queue
			return true;
		}
		
		
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String elementsInQueue = "";
		
		for(T s : genericArray) {
			if( s != null)
				elementsInQueue = elementsInQueue + s;
			
		}
		System.out.println("elementsInQueue = " + elementsInQueue);

		return elementsInQueue;
		
		
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		//System.out.println("The front = " + front);
		//System.out.println("The end = " + end);
		//System.out.println("numElements = " + numElements);
		//System.out.println("The sizeOfQueue = " + sizeOfQueue);

		String elementsDelimiterInQueue = "";
		
		for(T s : genericArray) {
			if(s != null ) {
				if(elementsDelimiterInQueue == "") {
					System.out.println("s = " + s);
					elementsDelimiterInQueue = elementsDelimiterInQueue + s;
				}
				else {
					System.out.println("s = " + delimiter + s);
					elementsDelimiterInQueue = elementsDelimiterInQueue + delimiter + s;

				}
			}
			
			
		}
		
		System.out.println("elementsDelimiterInQueue = " + elementsDelimiterInQueue);

		return elementsDelimiterInQueue;
		

		
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	public void fill(ArrayList<T> list) throws QueueOverflowException{
		System.out.println("The list = " + list + " and its size = " + list.size());
		System.out.println("The numElements = " + numElements);
		System.out.println("The sizeOfQueue = " + sizeOfQueue);

		int tempFront = 0;
		if( list.size() > sizeOfQueue) {
			System.out.println("Entry list is greater than the size of the queue");
			throw new QueueOverflowException();
		}
		else {
			for(T s : list) {
				System.out.println("The tempFront = " + tempFront + " , s = " + s);
				genericArray[tempFront] = s;
				System.out.println("generticArray[" + tempFront + "] = " + genericArray[tempFront]);
				tempFront++;
				numElements++;
			}
			

		}
		//System.out.println("genericArray = " + genericArray);

		
	}
		

}
