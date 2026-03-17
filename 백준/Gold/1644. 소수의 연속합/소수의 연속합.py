import sys

n = int(sys.stdin.readline())
prime = [True] * (n + 1)

for p in range(2, int(n ** 0.5 + 1)):
    if prime[p]:
        i = 2
        while p * i <= n:
            prime[p * i] = False
            i += 1

prime = [i for i in range(2, n + 1) if prime[i]]

start, end, sum = 0, 0, 0
ans = 0

while True:
    if sum >= n:
        if sum == n:
            ans += 1

        sum -= prime[start]
        start += 1

    else:
        if end == len(prime):
            break

        sum += prime[end]
        end += 1

print(ans)