cache = [];
const fibonacci = (index, cache = []) => {
  if (cache[index]) {
    return cache[index];
  } else {
    if (index < 3) {
      return 1;
    } else {
      cache[index] = fibonacci[index - 1] + fibonacci[index - 2];
    }
    return cache[index];
  }
};
