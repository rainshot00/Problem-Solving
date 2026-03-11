# from queue import PriorityQueue
# PriorityQueue = thread-safe -> slow
# heapq = thread-unsafe -> fast
import heapq

t = int(input())
answer = []

for testcase in range(1, t + 1):
    V, E = map(int, input().split())
    arr = [[] for _ in range(V + 1)]
    visited = [False] * (V + 1)

    for _ in range(E):
        u, v, w = map(int, input().split())
        arr[u].append((v, w))
        arr[v].append((u, w))

    pq = [(0, 1)]
    cnt, weight = 0, 0

    while pq:
        w, now = heapq.heappop(pq)

        if visited[now]:
            continue

        visited[now] = True
        weight += w
        cnt += 1

        if cnt == V:
            break

        for next_vertex, next_weight in arr[now]:
            if not visited[next_vertex]:
                heapq.heappush(pq, (next_weight, next_vertex))

    answer.append(f'#{testcase} {weight}')

print('\n'.join(answer))