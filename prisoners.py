def answer(x, y):
    if len(x) < len(y):
        x = set(x)
        for num in y:
            if num not in x:
                return num
    else:
        y = set(y)
        for num in x:
            if num not in y:
                return num


print(answer([13, 5, 6, 2, 5], [5, 2, 5, 13]))