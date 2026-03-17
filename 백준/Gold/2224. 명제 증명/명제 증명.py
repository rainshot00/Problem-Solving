import sys


def to_index(c):
    if 'A' <= c <= 'Z':
        return ord(c) - ord('A')
    else:
        return ord(c) - ord('a') + 26


def to_char(i):
    if i < 26:
        return chr(i + ord('A'))
    else:
        return chr(i - 26 + ord('a'))

n = int(sys.stdin.readline())
graph = [[False] * 52 for _ in range(52)]

for _ in range(n):
    u, _, v = sys.stdin.readline().split()
    u, v = to_index(u), to_index(v)
    graph[u][v] = True

for k in range(52):
    for u in range(52):
        for v in range(52):
            graph[u][v] = True if graph[u][k] and graph[k][v] else graph[u][v]

cnt = 0
answer = []
for u in range(52):
    for v in range(52):
        if graph[u][v] and u != v:
            cnt += 1
            answer.append(f'{to_char(u)} => {to_char(v)}')

print(cnt)
print('\n'.join(answer))