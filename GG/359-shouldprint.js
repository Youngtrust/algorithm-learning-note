var Logger = function () {
  this.map = new Map();
  this.obj = {};
};

/**
 * @param {number} timestamp
 * @param {string} message
 * @return {boolean}
 */
Logger.prototype.shouldPrintMessage = function (timestamp, message) {
  //     const obj = {}

  if (message in this.obj) {
    if (timestamp < this.obj[message] + 10) {
      return false;
    }
  }
  this.obj[[message]] = timestamp;

  return true;
};
