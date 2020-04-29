#https://www.hackerrank.com/challenges/balanced-brackets/problem
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    st = []
    for i in s:
        if i == '(' or i =='{' or i =='[':
            st.append(i)

        elif i == ')':
            if len(st)>0 and st[len(st)-1]=='(':
                del st[-1]
            else:
                st.append(i)
        elif i == ']':
            if len(st)>0 and st[len(st)-1]=='[':
                del st[-1]
            else:
                st.append(i)
        elif i == '}':
            if len(st)>0 and st[len(st)-1]=='{':
                del st[-1]
            else:
                st.append(i)

    if len(st)==0:
        return "YES"
    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
