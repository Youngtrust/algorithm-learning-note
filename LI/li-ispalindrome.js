// Palindrome check in Javascript

const isPalidrome = (str) => {
  return str == str.split("").reverse().join("");
};

const isPalidrome2 = (str) => {
  const len = Math.floor(str.length / 2);
  for (let i = 0; i < len; i++) {
    if (str[i] !== str[str.length - i - 1]) {
      return false;
    }
  }
  return true;
};

//isPalindrome('racecar');
