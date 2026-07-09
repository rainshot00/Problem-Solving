class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def bfs(i, k):
            dq = deque()
            dq.append((i, k))
            checked[i][k] = True

            while dq:
                y, x = dq.popleft()

                for i in range(4):
                    yy, xx = y + dy[i], x + dx[i]

                    if 0 <= yy < m and 0 <= xx < n and grid[yy][xx] == '1' and not checked[yy][xx]:
                        dq.append((yy, xx))
                        checked[yy][xx] = True
        
        m, n = len(grid), len(grid[0])
        checked = [[False] * n for _ in range(m)]
        dy = [1, 0, 0, -1]
        dx = [0, 1, -1, 0]
        ans = 0

        for i in range(m):
            for k in range(n):
                if grid[i][k] == '1' and not checked[i][k]:
                    ans += 1
                    bfs(i, k)

        return ans