# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return nums
        x = set(nums)
        res = []
        for i in range(1, len(nums)+1):
            if i not in x:
                res.append(i)
        return res
