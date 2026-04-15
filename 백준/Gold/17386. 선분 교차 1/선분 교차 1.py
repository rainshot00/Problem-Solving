import sys


def ccw(x1, y1, x2, y2, x3, y3):
    s = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2)

    if s > 0:
        return 1
    elif s == 0:
        return 0
    else:
        return -1


x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
x3, y3, x4, y4 = map(int, sys.stdin.readline().split())

ccw12 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)
ccw34 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)

print(1 if ccw12 < 0 and ccw34 < 0 else 0)