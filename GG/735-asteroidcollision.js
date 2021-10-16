// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10.
// The 5 and 10 never collide.

/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function (asteroids) {
  const s = [];
  // Negative asteroids to the left of the stack can be ignored.
  // They'll never collide.
  for (let i = 0; i < asteroids.length; i++) {
    a = asteroids[i];
    if (s.length == 0 || (s[s.length - 1] < 0 && a < 0)) {
      s.push(a);
    } else if (a > 0) {
      s.push(a);
    } else {
      // a is negative. It can only collide with positive ones in
      // the stack. The following will keep on iterating
      // until it is dealt with.
      const pop = s.pop();

      // positive pop beats negative a, so pick up pop
      // and re-add it to the stack.
      if (Math.abs(pop) > Math.abs(a)) {
        s.push(pop);

        // a has larger size than pop, so pop will get dropped
        // and we'll retry another iteration with the same
        // negative a asteroid and whatever the stack's state is.
      } else if (Math.abs(pop) < Math.abs(a)) {
        i--;
        // magnitude of positive pop and negative a are the same
        // so we can drop both of them.
      } else {
        continue;
      }
    }
    // a is negative. It can only collide with positive ones in
    // the stack. The following will keep on iterating
    // until it is dealt with.
  }
  return s;
};
