def hasAlternatingBits(n: int) -> bool:
    previous = -1
    while n > 0:
        if n % 2 == 0 and previous == 0:
            return False
        elif n % 2 == 1 and previous == 1:
            return False
        previous = n % 2
        n = n // 2
    return True