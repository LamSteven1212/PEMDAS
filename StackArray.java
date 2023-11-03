
public class StackArray<E> {
	private E stack[];
	private int t = -1;
	
	public StackArray() {
		stack = (E[]) new Object[9];
	}
	
	public StackArray(int capacity) {
		stack = (E[]) new Object[capacity];
	}
	
	public void resize(int newSize) {
		E[] temp = (E[]) new Object[newSize];
		for(int i = 0 ; i < stack.length ; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
	
	public int size() {
//		System.out.println("The size of the Stack is " + (t+1));
		this.t = 1 + this.t; 
		return this.t;
	}
	
	public boolean isEmpty() {
		if(this.t == -1) {
//			System.out.println("The stack is empty");
			return true;
		}
		else {
//			System.out.println("the stack is not empty");
			return false;
		}
	}
	
	public E top() {
		if(isEmpty()) {
//			System.out.println("The Stack is empty");
			return null;
		}
		else {
//			System.out.println("The top element is : " + stack[t]);
			return stack[this.t];
		}
	}
	
	public void push(E element) {
		if(this.t+1 == stack.length) {
			System.out.println("The Stack is full, we are going to call resize method and 20 spaces");
			resize(stack.length + 20);
			this.t= this.t+1;
			stack[t] = element;
		}
		else {
			this.t= this.t+1;
			stack[this.t] = element;
//			System.out.println(t);
		}
	}
	
	public E pop() {
		if(isEmpty()) {
//			System.out.println("The Stack is empty");
			return null;
		}
		else {
			E temp = stack[this.t];
			stack[this.t] = null;
			this.t= this.t-1;
//			System.out.println("The popped element is : " + temp);
			return temp;
		}
	}
	
	public void display() {
		for(E element : stack) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
