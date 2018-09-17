class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        if(row!=col) return;
        for(int i =0;i<=(row - i)-1;i++){
            //The lower bound of j should be the same as i.
            //If we scan the left side or left side of the inner loop, the right side will also be scanned.
            //Therefore, the maximum value of j will be as follows
            //i+1 will be the length of the right side have already been scanned with the corresponding i.
            for(int j = i;j<=(row - 1)-(i+1);j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-j][i];
                matrix[row-1-j][i] = matrix[row-1-i][row-1-j];
                matrix[row-1-i][row-1-j] = matrix[j][row-1-i];
                matrix[j][row-1-i] = temp ;
            }
        }
    }
}