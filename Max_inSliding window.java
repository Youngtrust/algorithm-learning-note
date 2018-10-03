/*
Given a large array of integers and a window of size w, 
find current maximum in the window as the window slides through the entire array.
*/
//hit:
//Heap
//Is it required to store all the elements of current window?
class maxSlidingWindow{
    public static void find_max_sliding_window(int[] array, int window_size) {
     
       if(array.length < window_size) {
          return;
       }
  
       ArrayDeque<Integer> window = new ArrayDeque<Integer>(); 
  
        //find out max for the first window    
       for(int i=0 ; i<window_size ; i++) {
    
          while(!window.isEmpty()
              && array[i] >= array[window.peekLast()] ) {
            window.removeLast();
          }
  
          window.addLast(i);
       }
  
       System.out.print(array[window.peekFirst()] + ", ");
    
       for(int i= window_size; i<array.length; i++) {
  
          //remove all numbers that are smaller than current number 
          //from the tail of queue
          while(!window.isEmpty()
              && array[i] >= array[window.peekLast()]) {
            window.removeLast();
          }
  
          //remove first number if it doesn't fall in the window anymore
          if(!window.isEmpty() 
            && window.peekFirst() <= i - window_size) {
            window.removeFirst();
          }
  
          window.addLast(i);
  
          System.out.print(array[window.peekFirst()] + ", ");
       }
    }
    public static void main(String[] args) {
          int[] array = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
          System.out.println("Window Size 4");
          find_max_sliding_window(array, 4);
  
          System.out.println("\nWindow Size 3");
          find_max_sliding_window(array, 3);
  
          System.out.println("\nWindow Size 5");
          find_max_sliding_window(array, 5);
    }
  }  