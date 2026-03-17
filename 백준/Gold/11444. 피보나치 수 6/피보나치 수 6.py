import sys


def multiply(A, B):
    C = [[0, 0], [0, 0]]

    for i in range(2):
        for j in range(2):
            for k in range(2):
                C[i][j] += A[i][k] * B[k][j]
                C[i][j] %= 1_000_000_007

    return C


def power(A, n):
    res = [[1, 0], [0, 1]]

    while n > 0:
        if n % 2 == 1:
            res = multiply(res, A)

        A = multiply(A, A)
        n //= 2

    return res


n = int(sys.stdin.readline())

fibonacci = [[1, 1], [1, 0]]

ans = power(fibonacci, n)
print(ans[0][1])