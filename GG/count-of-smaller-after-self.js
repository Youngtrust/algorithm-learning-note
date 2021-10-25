// 变体
//  给一个数组, 如 [2, 1, 3]，找出每个数字在该数字之后比它大的数的个数，比如：
//      比2大的有3，所以结果是1，
//      比1大的有3，结果也是1，

//      比3大的没有，结果是0，
//      所以返回 [1, 1, 0];

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var countSmaller = function (nums) {
  let bst = new BST(nums[nums.length - 1]);
  let outputArr = new Array(nums.length).fill(0);
  for (let j = nums.length - 2; j >= 0; j--) {
    outputArr[j] = bst.insert(nums[j]);
  }
  return outputArr;
};

class BST {
  constructor(v, s = 0) {
    this.value = v;
    this.left = null;
    this.right = null;
    this.size = s;
  }

  insert(v, s = 0) {
    if (v > this.value) {
      if (this.right == null) {
        this.right = new BST(v);
        return this.size + s + 1;
      } else {
        return this.right.insert(v, s + this.size + 1);
      }
    } else {
      this.size++;
      if (this.left == null) {
        this.left = new BST(v);
        return s;
      } else {
        return this.left.insert(v, s);
      }
    }
  }
}
