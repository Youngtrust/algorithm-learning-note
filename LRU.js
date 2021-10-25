class LRUCache {
  constructor(capacity) {
    this.cache = new Map();
    this.capacity = capacity;
  }

  get(key) {
    if (!this.cache.has(key)) return -1;

    let val = this.cache.get(key);

    this.cache.delete(key);
    this.cache.set(key, val);

    return val;
  }

  put(key, value) {
    this.cache.delete(key);

    if (this.cache.size === this.capacity) {
      this.cache.delete(this.cache.keys().next().value);
      this.cache.set(key, value);
    } else {
      this.cache.set(key, value);
    }
  }

  // Implement LRU/MRU retrieval methods
  getLeastRecent() {
    return Array.from(this.cache)[0];
  }

  getMostRecent() {
    return Array.from(this.cache)[this.cache.size - 1];
  }
}

// ====================================================================
const map1 = new Map();

map1.set("a", 1);
map1.set("b", 2);
map1.set("c", 3);

console.log(Array.from(map1));
console.log(map1.keys().next().value);

map1.delete("b");
map1.set("b", 2);
console.log(Array.from(map1));
// > Array [Array ["a", 1], Array ["b", 2], Array ["c", 3]]
// > "a"
// > Array [Array ["a", 1], Array ["c", 3], Array ["b", 2]]
