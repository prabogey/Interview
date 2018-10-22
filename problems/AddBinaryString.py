def convert(a, b):
    carry = False
    while(len(a) < len(b)):
        a = "0" + a
    while (len(b) < len(a)):
        b = "0" + b
    res = ""
    for x in range(len(a) - 1, -1, -1):
        if a[x] == "1" and b[x] == "1" and carry:
            carry = True
            res += "1"
        elif a[x] == "1" and b[x] == "1" and not carry:
            carry = True;
            res += "0"
        elif ((a[x] == "1" and b[x] == "0") or (a[x] == "0" and b[x] == "1")) and carry:
            carry = True;
            res += "0"
        elif ((a[x] == "1" and b[x] == "0") or (a[x] == "0" and b[x] == "1")) and not carry:
            res += "1"
        else:
            if not carry:
                res += "0"
            else:
                carry = False
                res += "1"
    if len(b) == len(a):
        if carry:
            res += "1"
    return res[::-1]

a = str(input("Enter a number: "))
b = str(input("Enter a number: "))
print(convert(a, b))