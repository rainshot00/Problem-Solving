import sys

n, k = map(int, sys.stdin.readline().split())

prime = [True] * (n + 1)
delete = []

for p in range(2, n + 1):
    if prime[p]:
        i = 1

        while p * i <= n:
            if prime[p * i]:
                delete.append(p * i)
                prime[p * i] = False

            i += 1

print(delete[k - 1])