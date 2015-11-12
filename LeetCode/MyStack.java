package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
	
	Deque<Integer> q = new ArrayDeque<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
        q.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.removeLast();
    }

    // Get the top element.
    public int top() {
        return q.getLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
