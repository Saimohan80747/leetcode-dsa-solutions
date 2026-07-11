class Node{
    int val;
    int key;
    Node next=null;
    Node prev=null;
    Node(int key,int val){
        this.val=val;
        this.key=key;
    }
}

class Dll{
    
    Node head,tail;
    Dll(){
       head=null;
       tail=null;
    }
    void addLast(Node nd){
        if(head==null && tail==null){
            head=nd;
            tail=nd;
        }
        tail.next=nd;
        nd.prev=tail;
        tail=nd;
    }
    void deleteNode(Node nd){
        if(nd==null) return;
        if(nd==head && nd==tail){
            head=null;
            tail=null;
        }else if(nd==head){
            Node nxt=head.next;
            head.next=null;
            nxt.prev=null;
            head=nxt;
        }else if(nd==tail){
            Node pre=tail.prev;
            pre.next=null;
            tail.prev=null;
            tail=pre;
        }else{
            Node nxt=nd.next;
            Node pre=nd.prev;
            nxt.prev=pre;
            pre.next=nxt;
            nd.prev=null;
            nd.next=null;
        }
    }
}

class LRUCache {
    HashMap<Integer,Node> map;
    Dll dll;
    int cap=0;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        dll=new Dll();
        cap=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            dll.deleteNode(map.get(key));
            dll.addLast(map.get(key));
            return map.get(key).val;
        }else{
           return -1;
        }
    }
    
    public void put(int key, int value) {
        Node nd=new Node(key,value);
        if(map.containsKey(key)){
            dll.deleteNode(map.get(key));
        }
        else if(map.size()==cap){
            Node head=dll.head;
            dll.deleteNode(head);
            map.remove(head.key);
        }
        map.put(key,nd);
        dll.addLast(nd);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */