import sys

answer = []
testcase = 1

while True:
    l, p, v = map(int, sys.stdin.readline().split())

    if l == 0 and p == 0 and v == 0:
        break

    day = v // p * l + min(v % p, l)
    answer.append(f'Case {testcase}: {day}')

    testcase += 1

print('\n'.join(answer))