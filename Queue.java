import java.util.*;


public class Queue<T> {
	private T[] queue;
	private int front, tail, size;
	
	public Queue(int capacity) {
		queue = (T[]) new Object[capacity];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public void enQueue(T data) {
		queue[tail] = data;
		tail = (tail+1) % queue.length;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
}
