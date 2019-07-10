"""
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
"""
def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
    result = []
    enum = {}
    for item in people:
        if item[0] in enum:
            enum[item[0]] += [item[1]]
        else:
            enum[item[0]] = [item[1]]
    for item in reversed(sorted(enum)):
        inFront = sorted(enum[item])
        for val in inFront:
            result.insert(val, [item, val])
    return result