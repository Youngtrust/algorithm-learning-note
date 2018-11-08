//Search 2d matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //n*m matrix convert to an array => matrix[x][y] => a[x*m +y]
        //an array convert to n*m matrix => a[x] => matrix[x/m][x%m]
        if(matrix.length == 0 || matrix[0].length ==0 || matrix ==null) 
            return false;
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
            
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >=0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
        
    }
}