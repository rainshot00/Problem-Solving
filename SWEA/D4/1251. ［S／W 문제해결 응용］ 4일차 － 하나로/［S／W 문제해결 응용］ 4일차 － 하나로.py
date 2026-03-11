import heapq

t = int(input())
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    x_pos = list(map(int, input().split()))
    y_pos = list(map(int, input().split()))
    tax = float(input())

    arr = [[] for _ in range(n)]
    visited = [False] * n

    for i in range(n):
        for k in range(n):
            if i == k:
                continue

            dist = (x_pos[i] - x_pos[k]) ** 2 + (y_pos[i] - y_pos[k]) ** 2
            arr[i].append((k, dist))
            arr[k].append((i, dist))

    pq = [(0, 0)]
    cnt, weight = 0, 0

    while pq:
        w, now = heapq.heappop(pq)

        if visited[now]:
            continue

        visited[now] = True
        weight += w
        cnt += 1

        if cnt == n:
            break

        for next_vertex, next_weight in arr[now]:
            if not visited[next_vertex]:
                heapq.heappush(pq, (next_weight, next_vertex))

    answer.append(f'#{testcase} {round(tax * weight)}')

print('\n'.join(answer))