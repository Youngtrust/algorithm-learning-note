/*
Given three integer arrays sorted in ascending order,
 find the smallest number that is common in all three arrays

 For example, let's look at the below three arrays.
  Here 6 is the smallest number that's common in all the arrays

  [6,7,10, 25, 30, 63, 64]
  [-1, 4, 5, 6, 7, 8, 50]
  [1, 6, 10, 14]

  Take advantage of the sorted array to reduce complexity.
Use three pointers.
  */
  class leastCommonNumber{
    static int find_least_common_number(int[] arr1, int[] arr2,int[] arr3) {
      int i=0, j=0, k=0;
  
      while(i < arr1.length && j < arr2.length && k < arr3.length) {
      
        // Found the smallest common number
        if(arr1[i] == arr2[j] &&
           arr2[j] == arr3[k]) {
          return arr1[i];
        }
  
        // Let's advance the iterator
        // for the smallest value.
  
        if(arr1[i] <= arr2[j] &&
           arr1[i] <= arr3[k]) {
         i++;
        }
        else if(arr2[j] <= arr1[i] &&
                arr2[j] <= arr3[k]) {
         j++;
        }
        else if(arr3[k] <= arr1[i] &&
                arr3[k] <= arr2[j]) {
         k++;
        }
      }
  
      return -1;
    }
    public static void main(String []args){
      int[] v1 = new int[]{1, 6, 10, 14, 50};
      int[] v2 = new int[]{-1, 6, 7, 8, 50};
      int[] v3 = new int[]{0, 6, 7, 10, 25, 30, 40};
      int result = find_least_common_number(v1, v2, v3);
      System.out.println("Least Common Number: " + result);
    }
  }  