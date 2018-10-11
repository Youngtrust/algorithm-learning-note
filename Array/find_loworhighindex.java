//Given a sorted array of integers, return the low and high index of the given key
//Return -1 if not found. The array length can be in millions with lots of duplicates.
class findLowHigh{
    static int find_low_index(
        List<Integer> arr,int key) {

            int low = 0;
            int high = arr.size()-1;
            int mid = high/2;
            
            while (low <= high) {
        
                int mid_elem = arr.get(mid);
        
                if (mid_elem < key) {
                low = mid+1;
                }
                else {
                high = mid-1;
                }
            
                mid = low + (high-low)/2;
            }
        
            if (arr.get(low) == key) {
                return low;
            }
  
      return -1;
    }
  
    static int find_high_index(
        List<Integer> arr,int key) {
    
            int low = 0;
            int high = arr.size()-1;
            int mid = high/2;
        
            while (low <= high) {
            
                int mid_elem = arr.get(mid);
            
                if (mid_elem <= key) {
                low = mid+1;
                }
                else {
                high = mid-1;
                }
        
                mid = low + (high-low)/2;
            }
        
            if (arr.get(high) == key) {
                return high;
            }
        
      return -1;
    }
    public static void main(String[] args) {
      List<Integer> array = Arrays.asList(1,1,1,2,2,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,6,6);
  
      int low = find_low_index(array, 5);
      int high = find_high_index(array, 5);
      System.out.println("LowIndex of 5 : "+low);
      System.out.println("HighIndex of 5 : "+high);
  
      low = find_low_index(array, 2);
      high = find_high_index(array, 2);
      System.out.println("LowIndex of 2 : "+low);
      System.out.println("HighIndex of 2 : "+high);
    }
  }  