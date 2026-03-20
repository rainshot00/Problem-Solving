import sys
import heapq


def dijkstra(st, ed):
    distance = [float('inf')] * n
    distance[st] = 0
    pq = [(0, st)]

    while pq:
        d, now = heapq.heappop(pq)

        if d > distance[now]:
            continue

        for next in range(n):
            if now == next:
                continue

            now_state = state[now]
            next_state = state[next]

            dist = 0
            for i in range(len(state[0])):
                dist += (now_state[i] - next_state[i]) ** 2

            if d + dist < distance[next]:
                distance[next] = d + dist
                heapq.heappush(pq, (distance[next], next))

    return distance[ed]


n = int(sys.stdin.readline())
state = []
for _ in range(n):
    state.append([int(digit) for digit in sys.stdin.readline().strip()])


st, ed = map(int, sys.stdin.readline().split())

print(dijkstra(st - 1, ed - 1))