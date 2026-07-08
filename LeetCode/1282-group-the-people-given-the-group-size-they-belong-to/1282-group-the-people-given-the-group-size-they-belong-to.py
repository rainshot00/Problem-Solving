from collections import defaultdict

class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        dict = defaultdict(list)
        ans = []

        for i in range(len(groupSizes)):
            size = groupSizes[i]
            dict[size].append(i)

            if len(dict[size]) == size:
                ans.append(dict[size])
                dict[size] = []

        return ans