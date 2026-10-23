class Node{
    int val=0,cnt=0,order=0;
    Node(int val,int cnt,int order){
        this.val=val;
        this.cnt=cnt;
        this.order=order;
    }
}
class FreqStack {
    int order=0;
    HashMap<Integer,Integer> map;
    PriorityQueue<Node> pq;
    public FreqStack() {
        map=new HashMap<>();
        pq=new PriorityQueue<>((a,b)->{
        if(a.cnt!=b.cnt) return b.cnt-a.cnt;
        return b.order-a.order;
        });
    }
    
    public void push(int val) {
        order++;
        int cnt=map.getOrDefault(val,0);
        Node node=new Node(val,cnt+1,order);
        pq.add(node);
        map.put(val,cnt+1);
    }
    
    public int pop() {
       Node nd=pq.poll();
       int cnt=map.get(nd.val);
       if(cnt>1) map.put(nd.val,cnt-1);
       else map.remove(nd.val);
       return nd.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */