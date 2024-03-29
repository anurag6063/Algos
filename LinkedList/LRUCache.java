

/*
[Note]
[Reference]: https://leetcode.com/problems/lru-cache/solutions/3780778/100-fast-very-easily-line-by-line-explained-c-java-python
[Problem]: https://leetcode.com/problems/lru-cache/description/?envType=list&envId=ruypfpvi
[Pattern]: HashMap and Double LL
[Tips]: Create everything and implement addNode and deleteNode
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: Create a HMap, a LL, Node class, when .. add more
[Code]	
	
[/Code]
[/Note]
*/
// used to create and hold the node data and refrence, this a double LL.
// will have a node that has the key, value, next and prev.
class Node{
    public int key;
    public int val;
    public Node next;
    public Node prev;


// constructor for Node; will instantiate the key and value and the next and prev to null. 
// so we take the responsiblity to the key and value. And I don't know about the refrence to next and prev, so it's null. You need to take care of prev and next.
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
// end of Node class and Constructor;

// The LRUCache
class LRUCache {
	
	// its a combination of Map and Double LL.
	// it will have a head and tail so initlally its HEAD --> <-- TAIL 
    private Map<Integer,Node> m;
    private Node head;
    private Node tail;
    private int size;

	// constructor for LRU cache , take's in capacity
	// here since it's a LL referred by Map, we will just create the above head and tail sturucture and leave it. 
	// size is just stored in the Object so that it can be used later for refrence.
    public LRUCache(int capacity){
        size = capacity;
        m = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
	// implementation
    private void deleteNode(Node p){
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode){
        Node temp = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }
    
    public int get(int key) {
		
		// either the key is present or absent 
     if(!m.containsKey(key)){
         return -1;
     }

     Node p = m.get(key);
     deleteNode(p);
     addNode(p);
     m.put(key, head.next);
     return head.next.val;
    }
    
	// when we add, either the key is present or absent 
		// if absent and the size is full we just need to update the node kay and value 
			// else we need to create a fresh Node. 
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node c = m.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            m.put(key, head.next);
        }else{
            if(m.size() == size){
                // the LRU is full
                Node prev = tail.prev;
                deleteNode(prev);
                Node l = new Node(key, value);
                addNode(l);
                m.remove(prev.key);
                m.put(key, head.next);
            }else{
                Node l = new Node(key, value);
                addNode(l);
                m.put(key, head.next);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */