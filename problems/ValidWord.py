class Node:
    def __init__(self, value, neighbors, name):
        self.value = value
        self.neighbors = neighbors
        self.name = name
    
    def __str__(self):
        return self.name
        
class Graph:
    def __init__(self, nodes):
        self.nodes = nodes
        
    def firstLetterNodes(self, word):
        new_nodes = []
        letter = word[0]
        for each in self.nodes:
            if each.value == letter:
                new_nodes.append(each)
        return new_nodes
    
a1 = Node('a', [], 'a1')
a2 = Node('a', [], 'a2')
b1 = Node('b', [], 'b1')
b2 = Node('b', [], 'b2')
k1 = Node('k', [], 'k1')
s1 = Node('s', [], 's1')
s2 = Node('s', [], 's2')
a1.neighbors.append(b1)
a2.neighbors.append(b1)
a2.neighbors.append(s1)
a2.neighbors.append(s2)
b1.neighbors.append(a1)
b1.neighbors.append(a1)
b2.neighbors.append(s1)
k1.neighbors.append(s2)
s1.neighbors.append(a2)
s1.neighbors.append(b2)
s2.neighbors.append(a2)
s2.neighbors.append(k1)

graph = Graph([a1, a2, b1, b2, s1, s2, k1])
word = "ask"

def validWord(graph, word):
    starter_nodes = graph.firstLetterNodes(word)
    graphLength = len(graph.nodes)
    visited = set()
    savedSubproblems = dict()
    for node in starter_nodes:
        visited.add(node)
        for neighbor in node.neighbors:
            if neighbor.value == word[1]:
                tempVisited = visited.copy() # deep copying the set
                res = recursiveHelper(neighbor, word, 2, visited, savedSubproblems, graphLength) # if we go to this node does this return true
                if res:
                    return True
                visited = tempVisited
        visited.remove(node)
    return False

def recursiveHelper(node, word, index, visited, savedSubproblems, lenGraph):
    visited.add(node)
    if index == len(word):
        if len(visited) == lenGraph:
            return True
        for item in visited:
            print(item, end=', ')
        print()
        visited.remove(node)
        return False
    
    if repr([node, index]) in savedSubproblems:
        return savedSubproblems[repr([node, index])]
    
    for neighbor in node.neighbors:
        if neighbor.value == word[index]:
            tempVisited = visited.copy() # deep copying the set
            res = recursiveHelper(neighbor, word, index + 1, visited, savedSubproblems, lenGraph) # if we go to this node does this return true
            if res:
                savedSubproblems[repr([node, index])] = True
                return True
            visited = tempVisited
    savedSubproblems[repr([node, index])] = False
    return False


print(validWord(graph, word))