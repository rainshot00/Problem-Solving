import sys

capacity, milk = [], []
for _ in range(3):
    c, m = map(int, sys.stdin.readline().split())
    capacity.append(c)
    milk.append(m)

idx = 0
for _ in range(100):
    now = idx
    next = (idx + 1) % 3

    pour = min(milk[now], capacity[next] - milk[next])
    milk[now] -= pour
    milk[next] += pour

    idx = (idx + 1) % 3

for m in milk:
    print(m)