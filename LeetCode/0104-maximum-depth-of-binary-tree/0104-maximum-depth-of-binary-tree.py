# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(now):
            if now is None:
                return 0
            
            return 1 + max(dfs(now.left), dfs(now.right))
        
        return dfs(root)