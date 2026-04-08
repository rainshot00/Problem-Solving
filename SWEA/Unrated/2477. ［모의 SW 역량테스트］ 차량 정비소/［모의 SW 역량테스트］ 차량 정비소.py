from collections import deque

t = int(input())
answer = []

for testcase in range(1, t + 1):
    reception_length, repair_length, customer, a, b = map(int, input().split())
    reception_set, repair_set = set(), set()

    reception_time = list(map(int, input().split()))
    repair_time = list(map(int, input().split()))
    arrive_time = list(map(int, input().split()))

    customer_history = [[-1, -1] for _ in range(customer + 1)]

    reception = [None] * reception_length
    repair = [None] * repair_length

    reception_waiting = deque()
    repair_waiting = deque()

    time = 0
    cnt = 0
    arrive_index = 0

    while cnt < customer:
        # repair에서 나가고
        for i in range(repair_length):
            if repair[i]:
                repair[i][1] -= 1

                if repair[i][1] == 0:
                    repair[i] = None
                    cnt += 1

        # reception에서 나가고
        for i in range(reception_length):
            if reception[i]:
                reception[i][1] -= 1

                if reception[i][1] == 0:
                    customer_index = reception[i][0]
                    repair_waiting.append(customer_index)
                    reception[i] = None

        # customer 도착하고
        while arrive_index < customer and arrive_time[arrive_index] <= time:
            reception_waiting.append(arrive_index + 1)
            arrive_index += 1

        # repair에 들어오고
        for i in range(repair_length):
            if repair_waiting and repair[i] is None:
                customer_index = repair_waiting.popleft()
                repair[i] = [customer_index, repair_time[i]]
                customer_history[customer_index][1] = i + 1

        # reception에 들어오고
        for i in range(reception_length):
            if reception_waiting and reception[i] is None:
                customer_index = reception_waiting.popleft()
                reception[i] = [customer_index, reception_time[i]]
                customer_history[customer_index][0] = i + 1

        time += 1

    res = 0
    for i in range(1, customer + 1):
        if customer_history[i][0] == a and customer_history[i][1] == b:
            res += i

    answer.append(f'#{testcase} {res if res > 0 else -1}')

print('\n'.join(answer))