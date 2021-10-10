// 1 6 7 13 14
// 2 5 8 12 15
// 3 4 9 11 16
// width: 5, height 3
import React from React




// Input:
// zigzagMatrix([[1, 2, 3, 4],[5, 6, 7, 8], [9, 0, 1, 2]]);
// Output:123487659012


// Time complexity: O(m * n).
// Space complexity: O(1).
let zigzagMatrix = (arr) => {
    //loop through the array
    for(let i = 0; i < arr.length; i++){
      
      if( i % 2 != 0){
   
        //If it is odd row then print in reverse direction
        for(let j = arr[i].length - 1; j >= 0; j--){
         console.log(arr[i][j]);
        }
       }else{
   
       //If it is even row then print in normal direction
       for(let j = 0; j < arr[i].length;  j++){
         console.log(arr[i][j]);
        }
       }
      }
    }