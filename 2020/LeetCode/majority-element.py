# https://leetcode.com/problems/majority-element
import math


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        map = {}
        for i in nums:
            if map.get(i) != None:
                map[i] = map.get(i)+1
            else:
                map[i] = 1
            if (map.get(i)) > math.floor(len(nums)/2):
                return i
