import sys


def kmp(word, pattern):
    pi = [0] * len(pattern)

    i = 0
    for j in range(1, len(pattern)):
        while i > 0 and pattern[i] != pattern[j]:
            i = pi[i - 1]

        if pattern[i] == pattern[j]:
            i += 1
            pi[j] = i

    match_cnt = 0
    match_idx = []

    i = 0
    for j in range(len(word)):
        while i > 0 and pattern[i] != word[j]:
            i = pi[i - 1]

        if pattern[i] == word[j]:
            i += 1

            if i == len(pattern):
                match_cnt += 1
                match_idx.append(j - len(pattern) + 2) # start index = 0이라서 +1
                i = pi[i - 1]

    return match_cnt, match_idx


word = list(sys.stdin.readline())[:-1]
pattern = list(sys.stdin.readline())[:-1]

cnt, idx = kmp(word, pattern)

print(cnt)
print(*idx)