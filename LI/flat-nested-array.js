function flatten(ary) {
  var ret = [];
  for (var i = 0; i < ary.length; i++) {
    if (Array.isArray(ary[i])) {
      ret = ret.concat(flatten(ary[i]));
    } else {
      ret.push(ary[i]);
    }
  }
  return ret;
}

flatten([[[[[0]], [1]], [[[2], [3]]], [[4], [5]]]]); // [0, 1, 2, 3, 4, 5]

const flatten = (ary) =>
  ary.reduce((a, b) => a.concat(Array.isArray(b) ? flatten(b) : b), []);
