import sys

n, m = map(int, sys.stdin.readline().split())
tmp = list(map(int, sys.stdin.readline().split()))
truth_num = tmp[0]
truth = tmp[1:]
truth_party = [False] * m

party = []
for i in range(m):
    party.append(list(map(int, sys.stdin.readline().split()))[1:])

    for person in party[i]:
        if person in truth:
            truth_party[i] = True

for _ in range(m):
    for person in range(1, n + 1):
        flag = None
        lier = False

        for party_num in range(m):
            if person in party[party_num]:
                if flag is None:
                    flag = truth_party[party_num]
                elif flag != truth_party[party_num]:
                    lier = True
                    break

        if lier:
            for party_num in range(m):
                if person in party[party_num]:
                    truth_party[party_num] = True

answer = 0
for tp in truth_party:
    if not tp:
        answer += 1

print(answer)