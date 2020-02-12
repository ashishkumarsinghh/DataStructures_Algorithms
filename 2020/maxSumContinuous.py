# https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
class Solution:
    # @param A : tuple of integers
    # @return an integer
    def checkAllNegative(self, A):
        max = A[0]
        for i in range(len(A)):
            if A[i] > 0:
                return 0
            elif A[i] > max:
                max = A[i]
        return max

    def maxSubArray(self, A):
        x = self.checkAllNegative(A)
        if x < 0:
            return x
        else:
            maxTillNow = 0
            currSum = 0
            for i in range(len(A)):
                currSum += A[i]
                if currSum < 0:
                    currSum = 0
                if currSum > maxTillNow:
                    maxTillNow = currSum
            return maxTillNow
