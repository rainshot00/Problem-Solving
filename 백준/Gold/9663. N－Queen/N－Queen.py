import sys


def queen(y, x):
    if y == n - 1:
        global answer
        answer += 1
        return

    for row in range(n):
        if not col[row] and not diag_pos[y + 1 + row] and not diag_neg[y + 1 - row + n]:
            col[row] = True
            diag_pos[y + 1 + row] = True
            diag_neg[y + 1 - row + n] = True
            queen(y + 1, row)
            col[row] = False
            diag_pos[y + 1 + row] = False
            diag_neg[y + 1 - row + n] = False


n = int(sys.stdin.readline())
board = [[False] * n for _ in range(n)]
answer = 0

col = [False] * n
diag_pos = [False] * (2 * n)
diag_neg = [False] * (2 * n)

for x in range(n):
    col[x] = True
    diag_pos[x] = True
    diag_neg[0 - x + n] = True
    queen(0, x)
    col[x] = False
    diag_pos[x] = False
    diag_neg[0 - x + n] = False

print(answer)