#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.


def minimumBribes(q):
    a = list(q)
    a.sort()
    bribe = 0

    for i in range(len(q)):
        if a[i] == q[i]:
            pass
        else:
            if a[i+1] == q[i]:
                temp = a[i+1]
                a[i+1] = a[i]
                a[i] = temp
                bribe += 1
            elif a[i+2] == q[i]:
                temp = a[i+2]
                a[i+2] = a[i+1]
                a[i+1] = temp
                bribe += 1
                temp = a[i+1]
                a[i+1] = a[i]
                a[i] = temp
                bribe += 1
            else:
                print("Too chaotic")
                return
    print(bribe)
    return


t = int(input())

for t_itr in range(t):
    n = int(input())

    q = list(map(int, input().rstrip().split()))

    minimumBribes(q)
