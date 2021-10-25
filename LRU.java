class LRUCache {
    int capacity;
    
    //LinkedListNode holds key and value pairs
    HashMap<Integer,LinkedListNode> cache; 
    LinkedList<LinkedListNode> cache_vals;
    public LRUCache(int capacity) {
      this.capacity = capacity;
      cache = new HashMap<Integer,LinkedListNode>(capacity);
      cache_vals = new LinkedList<LinkedListNode>();
    }
  
    int get(int key) {
      LinkedListNode node = cache.get(key);
  
      if(node == null){
        return -1;
      }
      else {
        cache_vals.remove(node);
        cache_vals.addLast(node);
        return node.data;
      }
    }
  
    void set(int key, int value) {
      LinkedListNode node = cache.get(key);
  
      if(node == null){
        evict_if_needed();
        node = new LinkedListNode(key, value);
        cache_vals.addLast(node);
        cache.put(key, node);
      }
      else {
        node.data = value;
        cache_vals.remove(node);
        cache_vals.addLast(node);
      }
    }
  
    void evict_if_needed(){
      if(cache_vals.size() >= capacity) {
        LinkedListNode node = cache_vals.remove();
        cache.remove(node.key);
      }
    }
  
    void print() {
      ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
      while(iterator.hasNext()){
        LinkedListNode node = iterator.next();
        System.out.print(node.key + ":" +node.data + ", ");  
      }
      System.out.println("");
    }





    
    public static void main(String[] args){
      LRUCache cache = new LRUCache(15);
      int key = 10; 
      int val = 20;
      cache.set(10, val);
      cache.print();
  
      cache.set(15, 25);
      cache.print();
  
      cache.set(20, 30);
      cache.print();
  
      cache.set(25, 35);
      cache.print();
    
      for (key = 10; key < 1000; ++key) {
        val = key + 10;
        cache.set(key, val);
        cache.print();
      }
    }
  }