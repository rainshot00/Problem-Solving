import sys

a, b = map(int, sys.stdin.readline().split())

res = a * (100 - b) / 100

print(0 if res >= 100 else 1)