/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    var n = matrix.length;
    var num = n / 2; // 旋转的次数
    var i = 0;
    if (num > 0) {
        while ( i < num) {
            let j = i;
                while (j < n - 1 - i) {
                    let originPos = {
                        x: i,
                        y: j
                    };
                    let targetPos = {
                        x: originPos.y,
                        y: n - 1 - originPos.x
                    };

                    let temp = matrix[originPos.x][originPos.y];
                    while (originPos.x !== targetPos.x || originPos.y !== targetPos.y) {
                        let v = matrix[targetPos.x][targetPos.y];
                        matrix[targetPos.x][targetPos.y] = temp;
                        let tempx = targetPos.x;
                        targetPos.x = targetPos.y;
                        targetPos.y = n - 1 - tempx;
                        temp = v;
                    }
                    matrix[targetPos.x][targetPos.y] = temp;
                    j++;
            }
            i++;
        }
    }
};