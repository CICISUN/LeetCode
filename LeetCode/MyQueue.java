package LeetCode;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> stk = new Stack<Integer>();
	Stack<Integer> stk2 = new Stack<Integer>();
	// Push element x to the back of queue.
	public void push(int x) {
		stk.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		int i = 0, n=stk.size();
		while(i<n-1){
			stk2.push(stk.pop());
			i++;
		}
		stk.pop();
		i=0;
		while(i<n-1){
		    stk.push(stk2.pop());
		    i++;
		}
	}

	// Get the front element.
	public int peek() {
		int i = 0, n=stk.size();
		while(i<n-1){
			stk2.push(stk.pop());
			i++;
		}
		int x = stk.peek();
		i=0;
		while(i<n-1){
		    stk.push(stk2.pop());
		    i++;
		}
		return x;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stk.isEmpty();   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		System.out.println(q.peek());
	}

}
