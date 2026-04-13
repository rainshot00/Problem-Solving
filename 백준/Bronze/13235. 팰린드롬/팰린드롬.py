import sys

string = sys.stdin.readline().strip()
answer = 'true'

for i in range(len(string)):
    if string[i] != string[-i-1]:
        answer = 'false'
        break

print(answer)