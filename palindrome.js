const palindrome = (iStr) => {
  const temp = removeSpaces(iStr).toLowerCase();
  return isPalindrome(temp, 0, temp.length - 1);
};

const removeSpaces = (iStr) => {
  return iStr.replace(/\s/g, "");
};

const isPalindrome = (iStr, start, end) => {
  if (start < end) {
    if (iStr.charAt(start) == iStr.charAt(end)) {
      return isPalindrome(iStr, start + 1, end - 1);
    } else return false;
  } else return true;
};
console.log(palindrome("never odd or even")); // true
console.log(palindrome("was it a rat I saw")); // true
console.log(palindrome("do geese see god")); // true
console.log(palindrome("elon musk")); // false
