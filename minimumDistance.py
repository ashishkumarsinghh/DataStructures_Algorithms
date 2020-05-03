# https://www.hackerrank.com/challenges/minimum-distances/problem


def minimumDistance(a):
    hm = {}
    for i in range(len(a)):
        if hm.get(a[i]):
            hm.get(a[i]).append(i)
        else:
            hm[a[i]] = [i]
    res = 100000
    for values in hm.values():
        for i in range(len(values)-1):
            x = abs(values[i]-values[i+1])
            if x < res:
                res = x
    return res if res != 100000 else -1


print(minimumDistance([3, 2, 1, 2, 3]))
