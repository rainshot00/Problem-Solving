import sys
from collections import deque


def divide(cnt):
    if cnt == n:
        area.append([area1.copy(), area2.copy()])
        return

    area1.append(cnt)
    divide(cnt + 1)
    area1.pop()

    area2.append(cnt)
    divide(cnt + 1)
    area2.pop()


def check(li):
    q = deque()
    visited = [False] * n

    q.append(li[0])
    visited[li[0]] = True

    while q:
        now = q.popleft()

        for x in range(n):
            if visited[x]:
                continue

            if arr[now][x] and (x in li):
                visited[x] = True
                q.append(x)

    for c in li:
        if not visited[c]:
            return False

    return True


n = int(sys.stdin.readline())
person = list(map(int, sys.stdin.readline().split()))
arr = [[False] * n for _ in range(n)]
ans = 987654321
area, area1, area2 = [], [], []

# input
for i in range(n):
    adj_list = list(map(int, sys.stdin.readline().split()))

    for k in range(1, len(adj_list)):
        arr[i][adj_list[k] - 1] = True

# brute force
divide(0)

for tmp in area:
    a1 = tmp[0]
    a2 = tmp[1]

    if len(a1) == 0 or len(a2) == 0:
        continue

    if not check(a1):
        continue

    if not check(a2):
        continue

    p1, p2 = 0, 0
    for city in a1:
        p1 += person[city]

    for city in a2:
        p2 += person[city]

    ans = min(ans, abs(p1 - p2))

if ans == 987654321:
    ans = -1

print(ans)
