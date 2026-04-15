import sys


def backtracking(color, idx, diag_pos, diag_neg):
    if idx == len(color):
        return 0

    y, x = color[idx]

    res1 = 0
    if not diag_pos[y + x] and not diag_neg[y - x + n - 1]:
        diag_pos[y + x] = True
        diag_neg[y - x + n - 1] = True
        res1 = backtracking(color, idx + 1, diag_pos, diag_neg) + 1
        diag_pos[y + x] = False
        diag_neg[y - x + n - 1] = False

    res2 = backtracking(color, idx + 1, diag_pos, diag_neg)

    return max(res1, res2)


n = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
black, white = [], []
diag_pos = [False] * (2 * n)
diag_neg = [False] * (2 * n)

for y in range(n):
    for x in range(n):
        if board[y][x] == 1:
            if y % 2 == x % 2:
                black.append((y, x))
            else:
                white.append((y, x))

black_cnt = backtracking(black, 0, diag_pos, diag_neg)
white_cnt = backtracking(white, 0, diag_pos, diag_neg)

print(black_cnt + white_cnt)