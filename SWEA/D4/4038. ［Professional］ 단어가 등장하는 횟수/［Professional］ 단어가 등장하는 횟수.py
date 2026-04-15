def kmp(word, pattern):
    pi = [0 for _ in range(len(pattern))]

    i = 0
    for j in range(1, len(pattern)):
        while i > 0 and pattern[i] != pattern[j]:
            i = pi[i - 1]

        if pattern[i] == pattern[j]:
            i += 1
            pi[j] = i

    res = 0
    i = 0
    for j in range(len(word)):
        while i > 0 and pattern[i] != word[j]:
            i = pi[i - 1]

        if pattern[i] == word[j]:
            i += 1

            if i == len(pattern):
                res += 1
                i = pi[i - 1]

    return res


t = int(input())
answer = []

for testcase in range(1, t + 1):
    word = list(input().strip())
    pattern = list(input().strip())

    answer.append(f'#{testcase} {kmp(word, pattern)}')

print('\n'.join(answer))