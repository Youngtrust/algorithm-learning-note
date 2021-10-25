const memoizeFib = (index, cache = []) => {
  // console.log('index :', index, '   cache:', cache)

  // > Array [undefined, undefined, undefined, 2, 3, 5, 8, 13]
  // > Array [undefined, undefined, undefined, 2, 3, 5, 8, 13, 21]
  // > Array [undefined, undefined, undefined, 2, 3, 5, 8, 13, 21, 34]

  if (cache[index]) {
    return cache[index];
  } else {
    if (index < 3) return 1;
    else {
      cache[index] =
        memoizeFib(index - 1, cache) + memoizeFib(index - 2, cache);
    }
  }
  return cache[index];
};

console.log(memoizeFib(5));
