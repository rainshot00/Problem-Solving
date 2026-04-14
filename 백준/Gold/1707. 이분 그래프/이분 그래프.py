import sys
sys.setrecursionlimit(10**5)

def dfs(now, color):
    bipartite[now] = color

    for next in graph[now]:
        if bipartite[next] is None:
            if not dfs(next, not color):
                return False
        else:
            if bipartite[next] == color:
                return False

    return True


t = int(sys.stdin.readline())
answer = []

for _ in range(t):
    v, e = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(v + 1)]
    bipartite = [None] * (v + 1)

    for _ in range(e):
        i, j = map(int, sys.stdin.readline().split())
        graph[i].append(j)
        graph[j].append(i)

    ans = True
    for vertex in range(1, v + 1):
        if bipartite[vertex] is None:
            if not dfs(vertex, True):
                ans = False
                break

    if ans:
        answer.append('YES')
    else:
        answer.append('NO')

print('\n'.join(answer))