import sys


class TrieNode:
    def __init__(self):
        self.child = {}
        self.is_end = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, string):
        curr = self.root

        for char in string:
            if curr.is_end:
                return False

            if char not in curr.child:
                curr.child[char] = TrieNode()

            curr = curr.child[char]

        if curr.child:
            return False

        curr.is_end = True
        return True


t = int(sys.stdin.readline())
answer = []

for _ in range(t):
    n = int(sys.stdin.readline())
    arr = [sys.stdin.readline().strip() for _ in range(n)]

    arr.sort()

    trie = Trie()
    flag = True

    for number in arr:
        if not trie.insert(number):
            flag = False
            break

    answer.append('YES' if flag else 'NO')

print('\n'.join(answer))