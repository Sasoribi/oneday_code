package io.sasoribi.algorithm.calculate;

/**
 * 运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * <p>
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <p>
 * 输出
 * <p>
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * <p>
 * LRUCache lRUCache = new LRUCache(2);
 * <p>
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * <p>
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * <p>
 * lRUCache.get(1);    // 返回 1
 * <p>
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * <p>
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * <p>
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * <p>
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * <p>
 * lRUCache.get(3);    // 返回 3
 * <p>
 * lRUCache.get(4);    // 返回 4
 */
public class LRUCache {
    
    private final Node[] cache;
    private final int size;
    private Node head;
    private Node tail;
    private int currentSize = 0;
    public LRUCache(int capacity) {
        cache = new Node[10000];
        size = capacity;
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    
    
    public int get(int key) {
        Node result = cache[key];
        if (result != null) {
            refreshNode(result);
            return result.getVal();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node old = cache[key];
        if (old != null) {
            old.setVal(value);
            refreshNode(old);
            return;
        }
        
        //add new node-关键(InsertAction)
        if (++currentSize > size) {
            removeLastNode();
        }
        
        Node newNode = new Node(key, value);
        cache[newNode.getKey()] = newNode;
        refreshNode(newNode);
    }
    
    
    private void insertHead(Node node) {
        if (head == null) {
            tail = head = node;
            return;
        }
        
        node.setNext(head);
        node.setPrev(null);
        
        head.setPrev(node);
        
        head = node;
    }
    
    private void removeLastNode() {
        if (head == tail) {
            //only one node
            cache[head.getKey()] = null;
        } else {
            Node prev = tail.prev;
            cache[tail.getKey()] = null;
            tail = prev;
        }
        
        currentSize--;
    }
    
    /**
     * 刷新Head引用-AccessOrInsertOrUpdate
     * @param node
     */
    private void refreshNode(Node node) {
        //如果是头结点,不刷新-关键
        if (head == node)
            return;
        
        Node prev = node.getPrev();
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        
        if (tail == node) {
            //only one node
            if (head != tail) {
                tail = prev;
            }
        }
        insertHead(node);
    }
    
    static class Node {
        private int val;
        private Node next;
        private Node prev;
        private int key;
        
        
        public Node() {
        }
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        public int getVal() {
            return val;
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public Node getNext() {
            return next;
        }
        
        public void setNext(Node next) {
            this.next = next;
        }
        
        public int getKey() {
            return key;
        }
        
        public void setKey(int key) {
            this.key = key;
        }
        
        public Node getPrev() {
            return prev;
        }
        
        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
