# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        ans = []
        dq = deque()
        dq.append((1, root))

        while dq:
            height, now = dq.popleft()

            if height > len(ans):
                ans.append([])
            
            ans[height - 1].append(now.val)

            if now.left is not None:
                dq.append((height + 1, now.left))
            if now.right is not None:
                dq.append((height + 1, now.right))

        return ans