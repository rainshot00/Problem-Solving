from itertools import permutations


t = int(input())
answer = []

for testcase in range(1, t + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    startX, startY = arr[0], arr[1]
    endX, endY = arr[2], arr[3]
    arr = arr[4:]
    customer = [(arr[i], arr[i + 1]) for i in range(0, len(arr), 2)]

    ans = 987654321

    for permutation in permutations(customer):
        res = (abs(startX - permutation[0][0]) + abs(startY - permutation[0][1]))

        for i in range(n - 1):
            res += (abs(permutation[i][0] - permutation[i + 1][0]) + abs(permutation[i][1] - permutation[i + 1][1]))

        res += (abs(endX - permutation[-1][0]) + abs(endY - permutation[-1][1]))

        if res < ans:
            ans = res

    answer.append(f'#{testcase} {ans}')

print('\n'.join(answer))