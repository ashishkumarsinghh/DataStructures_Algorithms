# https://www.hackerrank.com/challenges/repeated-string/problem
'''
Lilah has a string s, of lowercase English letters that she repeated infinitely many times.
Given an integer n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
'''

#Strategy
'''
1. Find the positions of character a in the string s
2. check how many times a will come, while p < n, p+=len(s)
'''

#Code
import math
def repeatedString(s, n):
    l = len(s)
    count = 0
    for i in range(l):
        if s[i]=='a':
            count+=1
    count *= (n//l)
    rStrLen = n % l
    for i in range(rStrLen):
        if s[i]=='a':
            count+=1
    return count

print(repeatedString("aba", 10))
print(repeatedString("a", 1000000000000))
