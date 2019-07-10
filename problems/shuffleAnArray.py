import random

'''
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
'''

class Solution:
    nums = []
    def __init__(self, nums: List[int]):
        self.nums = nums

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        return self.nums


    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        shuffled = []
        added = set()
        for i in range(len(self.nums)):
            x = -1
            while True:
                x = random.randint(0, len(self.nums) - 1)
                if x not in added:
                    added.add(x)
                    break
            shuffled.append(self.nums[x])
        return shuffled

    def fisherYatesShuffle(self) -> List[int]:
        ret = self.nums
        for i in range(len(self.nums)):
            x = random.randint(i, len(self.nums))
            ret[i], ret[x] = ret[x], ret[i]
        return ret