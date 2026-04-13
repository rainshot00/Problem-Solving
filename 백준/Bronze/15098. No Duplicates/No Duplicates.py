import sys

arr = list(sys.stdin.readline().strip().split())
s = set()
for word in arr:
    s.add(word)

if len(s) == len(arr):
    print('yes')
else:
    print('no')