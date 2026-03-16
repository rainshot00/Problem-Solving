import sys


def check(cnt, sum, select):
    global ans

    if cnt == n:
        if sum == s:
            if select > 0:
                ans += 1

        return

    check(cnt + 1, sum, select)
    check(cnt + 1, sum + arr[cnt], select + 1)


n, s = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

ans = 0
check(0, 0, 0)

print(ans)