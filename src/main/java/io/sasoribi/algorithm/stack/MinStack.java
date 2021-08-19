package io.sasoribi.algorithm.stack;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant -> O(1) time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    
    private ListNode head;
    private ListNode minium;
    
    public MinStack() {
    }
    
    public void push(int val) {
        //initial head
        if (head == null) {
            head = new ListNode(val, null,head);
            minium = head;
            return;
        }
        head = new ListNode(val, head,null);
        
        if (head.val < minium.val) {
            head.setUnder(minium);
            minium = head;
        }
    }
    
    public void pop() {
        if (head.equals(minium)) {
            minium = minium.under;
        }
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return minium.val;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode under;
        
        
        public ListNode(int val, ListNode next,ListNode under) {
            this.val = val;
            this.next = next;
            this.under = under;
        }
        
        public ListNode() {
        }
        
        
        public int getVal() {
            return val;
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public ListNode getNext() {
            return next;
        }
        
        public void setNext(ListNode next) {
            this.next = next;
        }
        
        public ListNode getUnder() {
            return under;
        }
        
        public void setUnder (ListNode under) {
            this.under = under;
        }
    }
}