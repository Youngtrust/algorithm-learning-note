/**
 * initialize your data structure here.
 */
 var MaxStack = function() {
    this.stack = [];
    this.max = [];
  };
  
  /** 
  * @param {number} x
  * @return {void}
  */
  MaxStack.prototype.push = function(x) {
    this.stack.push(x);
    if (this.max.length === 0 || x >= this.max[this.max.length -1]){
      this.max.push(x);
    }
    return x;
  };
  
  /**
  * @return {number}
  */
  MaxStack.prototype.pop = function() {
    var item = this.stack.pop();
    if (item === this.max[this.max.length -1]){
      this.max.pop();
    }
    return item;
  };
  
  /**
  * @return {number}
  */
  MaxStack.prototype.top = function() {
    return this.stack.length ? this.stack[this.stack.length -1]: null;
  };
  
  /**
  * @return {number}
  */
  MaxStack.prototype.peekMax = function() {
    return this.max.length ? this.max[this.max.length -1]: null;
  };
  
  /**
  * @return {number}
  */
  MaxStack.prototype.popMax = function() {
    var maxitem = this.max.pop();
    var temp = [];
    // 最关键的就是这里，如果不是maxitem那么我们就要把这些数字存起来，然后等我们把maxitem在stack里面pop掉了以后，
    // 再把他们一个个放回去, 而不可以直接把maxitem从stack里面抽走，因为这样的话会影响到下一个popMax的结果
    for (var i = this.stack.length -1; i >= 0; i--){
      if (this.stack[i] === maxitem){
        this.stack.splice(i, 1);
        break;
      }else{
        temp.push(this.stack.pop());
      }
    }
    while(temp.length){
      this.push(temp.pop());
    }
    return maxitem;
  };
  
  /** 
  * Your MaxStack object will be instantiated and called as such:
  * var obj = new MaxStack()
  * obj.push(x)
  * var param_2 = obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.peekMax()
  * var param_5 = obj.popMax()
  */