# https://www.hackerrank.com/challenges/two-strings/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the twoStrings function below.


def twoStrings(s1, s2):
    myD = {}
    for x in s1:
        myD[x] = 1
    for x in s2:
        if(myD.get(x, 0) == 1):
            return "YES"
    return "NO"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s1 = input()

        s2 = input()

        result = twoStrings(s1, s2)

        fptr.write(result + '\n')

    fptr.close()
