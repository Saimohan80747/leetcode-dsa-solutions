class Node{
    int val;
    int key;
    int order;
    int freq;
    Node next=null;
    Node prev=null;
    Node(int key,int val,int order){
        this.val=val;
        this.key=key;
        this.order=order;
        freq=1;
    }
}




class LFUCache {

    HashMap<Integer,Node> map;
    PriorityQueue<Node> pq;
    int cap=0;
    int order=0;
    public LFUCache(int capacity) {
        map=new HashMap<>();
        pq=new PriorityQueue<>((a,b)->{
            if(a.freq==b.freq) return a.order-b.order;
            return a.freq-b.freq;
        });
        cap=capacity;
    }
    
    public int get(int key) {
        order++;
        if(map.containsKey(key)){
            Node nd=map.get(key);
            pq.remove(nd);
            nd.freq++;
            nd.order = order;
            pq.add(nd);
            return nd.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        order++;
        if(map.containsKey(key)){
            Node nd=map.get(key);
            pq.remove(nd);
            nd.val = value;
            nd.freq++;
            nd.order = order;
            pq.add(nd);
        }else{
            if(map.size()==cap){
                Node node=pq.poll();
                map.remove(node.key);
            }
            Node nd=new Node(key,value,order);
            pq.add(nd);
            map.put(key,nd);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */