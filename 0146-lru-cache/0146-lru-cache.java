 class Node{
    Node prev=null;
    Node nxt=null;
    int key;
    int val;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class DoubleLinkedList{
       
        Node head=null;
        Node tail=null;
        void addAtLast(Node nd){
            if(tail==null){
                head=nd;
            }else{
                tail.nxt=nd;
                nd.prev=tail;
            }
            tail=nd;
            
        }
        void delete(Node nd){
            Node next=nd.nxt;
            Node prev=nd.prev;
            if(nd==head) head=next;
            if (prev!=null) nd.prev.nxt=next;
            if(next!=null) nd.nxt.prev=prev;
            nd.nxt=null;
            nd.prev=null;
        }
}
class LRUCache {
   
    HashMap<Integer,Node> cache=new HashMap<>();
    int size=0;
    DoubleLinkedList l;
    public LRUCache(int capacity) {
        size=capacity;
        l=new DoubleLinkedList();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node nd=cache.get(key);
            if(nd!=l.tail){
                l.delete(nd);
                l.addAtLast(nd);
            }
            return nd.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node nd=cache.get(key);
            nd.val=value;
            if(nd!=l.tail){
                l.delete(nd);
                l.addAtLast(nd);
            }
        }else{
            Node nd=new Node(key,value);
            l.addAtLast(nd);
            cache.put(key,nd);
            if(cache.size()>size){
                int k=l.head.key;
                cache.remove(k);
                l.delete(l.head);
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