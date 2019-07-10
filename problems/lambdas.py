# tutorial page on lambdas in python
# will show multiple examples of how to use them in different scenarios

def addFunc(x, y):
    return x + y

add = lambda x,y: x + y

addFunc(3,4)
add(3,4)

map(lambda x: x**2, [1,2,3,4,5])

filter(lambda x: x % 2 == 0, [2,4,5,6,10,90,61])

dict_a = [{'name': 'python', 'points': 10}, {'name': 'java', 'points': 8}]

map(lambda x : x['name'], dict_a) # Output: ['python', 'java']

map(lambda x : x['points']*10,  dict_a) # Output: [100, 80]

map(lambda x : x['name'] == "python", dict_a) # Output: [True, False]

# in python 3 these functions are lazy and just return an iterator
# have to convert it to a list before you use it


list_a = [1, 2, 3]
list_b = [10, 20, 30]

map(lambda x, y: x + y, list_a, list_b) # Output: [11, 22, 33]

filter(lambda x : x['name'] == 'python', dict_a) # Output: [{'name': 'python', 'points': 10}]


sorted("This is a test string from Andrew".split(), key=str.lower)
# ['a', 'Andrew', 'from', 'is', 'string', 'test', 'This']

student_tuples = [
        ('john', 'A', 15),
        ('jane', 'B', 12),
        ('dave', 'B', 10),
]
sorted(student_tuples, key=lambda student: student[2])   # sort by age
# [('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]

# sorted(student_objects, key=lambda student: student.age)   # sort by age
# [('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]

dict_b = {1: 'Soni', 4: 'Pranav', 6: 'Mike', 2: 'Go', 3: 'Random'}
print(sorted(dict_b, key=lambda key: -key))
print(dict_b)
