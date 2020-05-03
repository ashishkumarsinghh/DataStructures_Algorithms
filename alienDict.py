# python 3.5.2
import heapq
import sys


class Graph:
    def __init__(self, n):
        self.graph = {}
        for i in n:
            self.graph[i] = []
        self.V = len(n)

    def edge(self, i, j):
        self.graph[i].append(j)

    def tpUtil(self, v, visited, stack):
        visited[v] = True
        for i in self.graph[v]:
            if visited[i] == False:
                self.tpUtil(i, visited, stack)
        stack.insert(0, v)

    def tpSort(self, n):
        visited = {}
        for i in n:
            visited[i] = False
        stack = []
        for i in self.graph:
            if visited[i] == False:
                self.tpUtil(i, visited, stack)
        return stack

#
# @param {string[]} words
# @return {string[]}
#


def reconstruct_alphabet(words):
    result = []
    # Put your code here
    n = list(set("".join(words)))
    g = Graph(n)
    for i in range(len(words)-1):
        w1 = words[i]
        w2 = words[i+1]
        for j in range(min(len(w1), len(w2))):
            if w1[j] != w2[j]:
                g.edge(w1[j], w2[j])
                break
    result = g.tpSort(n)
    # Return the result, do not change the structure
    return result


if __name__ == "__main__":

    words = []
    all_lines = sys.stdin.readlines()
    for line in all_lines:
        if not line or not line.strip():
            continue

        words.append(line.strip())

    result = reconstruct_alphabet(words)
    print("".join([str(elem) for elem in result]))
