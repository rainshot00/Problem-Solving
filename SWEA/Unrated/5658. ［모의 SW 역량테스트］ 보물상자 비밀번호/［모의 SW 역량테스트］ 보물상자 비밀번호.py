t = int(input())
answer = []

for testcase in range(1, t + 1):
    n, k = map(int, input().split())
    number = input().strip()
    s = set()

    for _ in range(n):
        sp = n // 4

        s.add(int(number[:sp], 16))
        s.add(int(number[sp : 2 * sp], 16))
        s.add(int(number[2 * sp : 3 * sp], 16))
        s.add(int(number[3 * sp:], 16))

        tmp = number[0]
        number = number[1:]
        number += tmp

    s = sorted(s, reverse=True)

    answer.append(f'#{testcase} {s[k - 1]}')

print('\n'.join(answer))