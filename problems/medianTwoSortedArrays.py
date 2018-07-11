def findMedian(nums1, nums2):
    """
    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: float
    """
    nums1.extend(nums2)
    nums1.sort()
    if (len(nums1) % 2 != 0):
        return float(nums1[len(nums1)//2])
    else:
        return float( ((nums1[(len(nums1)//2) - 1]) + (nums1[len(nums1)//2])) /2)