"""
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5


Example 2:

Input: 3
Output: False

"""


def judgeSquareSum(self, c: int) -> bool:
    pairs = set()
    start = int(math.sqrt(c))
    if c == 0 or c == 1 or c == 2:
        return True
    for i in range(1, start + 1):
        sq = i ** 2;
        if c == sq or c - sq == sq or sq in pairs:
            return True
        pairs.add(c - sq)
    return False
