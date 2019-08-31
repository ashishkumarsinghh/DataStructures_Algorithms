# https://leetcode.com/problems/flipping-an-image/
class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        k = 0
        for l in A:
            l.reverse()
            for i in range(len(l)):
                if l[i] == 0:
                    l[i] = 1
                else:
                    l[i] = 0
            k += 1

        return A
