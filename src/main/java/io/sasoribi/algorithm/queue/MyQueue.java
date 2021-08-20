package io.sasoribi.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a stack, which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */
class MyQueue {
    
    Deque<Integer> main = new LinkedList<>();
    
    Deque<Integer> auxiliary = new LinkedList<>();
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    public MyQueue() {
    
    }
    
    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        main.push(x);
    }
    
    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //补充输出栈
        if (auxiliary.isEmpty()) {
            fullfilAux();
        }
        return auxiliary.pop();
    }
    
    /**
     * Get the front element.
     */
    public int peek() {
        if (auxiliary.isEmpty()) {
            fullfilAux();
        }
        return auxiliary.peek() == null ? 0 :auxiliary.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return main.isEmpty() && auxiliary.isEmpty();
    }
    
    private void fullfilAux() {
        while (main.peek() != null) {
            auxiliary.push(main.pop());
        }
    }
}

