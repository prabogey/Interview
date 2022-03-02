def findLongestConsecSequence(arr):
    cont = set(arr)
    atLeastOneExists = set()
    seen = set()
    for item in arr:
        if item + 1 in cont:
            atLeastOneExists.add(item)

    largest = 0
    for item in atLeastOneExists:
        if item in seen:
            continue
        counter = 1
        it = item
        while it - 1 in cont:
            largest += 1
            it -= 1
            seen.add(it)
            atLeastOneExists.remove(it)
        it = item
        while it + 1 in cont:
            counter += 1
            it += 1
            seen.add(it)
            atLeastOneExists.remove(it)
        if counter > largest:
            largest = counter
    return largest

def driver():
    arr = [100, 4, 8, 9, 10, 200, 1, 3, 2, 6, 7]
    print(findLongestConsecSequence(arr))

driver()
