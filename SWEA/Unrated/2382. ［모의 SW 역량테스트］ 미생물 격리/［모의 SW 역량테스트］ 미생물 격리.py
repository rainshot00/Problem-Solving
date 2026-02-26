import copy

t = int(input())

print_list = []
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

for testcase in range(1, t + 1):
    n, m, k = map(int, input().split())
    dict = {}

    for i in range(k):
        y, x, num, direction = map(int, input().split())

        dict[(y, x)] = [num, num, direction - 1]

    for time in range(m):
        size = len(dict)

        # [sumNum, maxNum, direction]
        new_dict = {}

        for key in dict.keys():
            y = key[0]
            x = key[1]
            num = dict[key][0]
            direction = dict[key][2]

            yy = y + dy[direction]
            xx = x + dx[direction]

            if yy == 0:
                direction = 1
                num //= 2
            elif yy == (n - 1):
                direction = 0
                num //= 2
            elif xx == 0:
                direction = 3
                num //= 2
            elif xx == (n - 1):
                direction = 2
                num //= 2

            if num == 0:
                continue

            # 충돌
            if (yy, xx) in new_dict:
                sumNum, maxNum, d = map(int, new_dict[(yy, xx)])

                if num > maxNum:
                    new_dict[(yy, xx)] = [sumNum + num, num, direction]
                else:
                    new_dict[(yy, xx)] = [sumNum + num, maxNum, d]

            else:
                new_dict[(yy, xx)] = [num, num, direction]

        dict = copy.deepcopy(new_dict)

    ans = 0
    for value in dict.values():
        ans += value[0]

    print_list.append(f'#{testcase} {ans}\n')

print(''.join(print_list))