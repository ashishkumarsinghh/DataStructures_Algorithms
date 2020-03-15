def countTriplets(arr, r):
    count = 0
    myD = {}

    for i in range(len(arr)):
        if(myD.get(arr[i], 0) == 0):
            myD[arr[i]] = 1

        else:
            myD[arr[i]] = myD[arr[i]]+1

    for key, value in myD.items():
        if(myD.get(key*r, 0) != 0 and myD.get(key*r*r, 0) != 0):
            count += (myD[key]*myD[key*r]*myD[key*r*r])

    return count


nr = input().rstrip().split()
n = int(nr[0])

r = int(nr[1])

arr = list(map(int, input().rstrip().split()))

ans = countTriplets(arr, r)
print(ans)
