class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        r, c = len(grid), len(grid[0])
        dy = [1, 0, 0, -1]
        dx = [0, 1, -1, 0]
        checked = [[False] * c for _ in range(r)]
        ans = 0

        def bfs(i, k):
            nonlocal ans
            dq = deque()
            dq.append((i, k))
            checked[i][k] = True

            while dq:
                y, x = dq.popleft()

                for i in range(4):
                    yy, xx = y + dy[i], x + dx[i]

                    if not 0 <= yy < r or not 0 <= xx < c:
                        ans += 1
                    
                    elif grid[yy][xx] == 0:
                        ans += 1
                    
                    elif not checked[yy][xx]:
                        checked[yy][xx] = True
                        dq.append((yy, xx))

        for i in range(r):
            for k in range(c):
                if grid[i][k] == 1:
                    bfs(i, k)
                    return ans