class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        dy = [0, 1, -1, 0]
        dx = [1, 0, 0, -1]
        checked = [[False] * n for _ in range(m)]

        def dfs(y, x, idx):
            if idx == len(word):
                return True
            
            for i in range(4):
                yy, xx = y + dy[i], x + dx[i]

                if 0 <= yy < m and 0 <= xx < n and not checked[yy][xx] and board[yy][xx] == word[idx]:
                    checked[yy][xx] = True

                    if dfs(yy, xx, idx + 1):
                        return True
                        
                    checked[yy][xx] = False
            
            return False
        
        for i in range(m):
            for k in range(n):
                if board[i][k] == word[0]:
                    checked[i][k] = True
                    
                    if dfs(i, k, 1):
                        return True
                
                    checked[i][k] = False
        
        return False