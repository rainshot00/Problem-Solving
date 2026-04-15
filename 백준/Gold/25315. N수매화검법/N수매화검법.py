import sys


def ccw(x1, y1, x2, y2, x3, y3):
    return (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2)


n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
arr.sort(key=lambda x: x[4])
ans = 0

for i in range(n):
    x3, y3, x4, y4 = arr[i][0], arr[i][1], arr[i][2], arr[i][3]
    cnt = 0

    for k in range(i + 1, n):
        x1, y1, x2, y2 = arr[k][0], arr[k][1], arr[k][2], arr[k][3]

        ccw12 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)
        ccw34 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)

        if ccw12 < 0 and ccw34 < 0:
            cnt += 1

    ans += (cnt + 1) * arr[i][4]

print(ans)