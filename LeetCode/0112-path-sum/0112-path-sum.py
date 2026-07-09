# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(now, sum):
            if now is None:
                return False
            
            sum += now.val
            
            if sum == targetSum and now.left is None and now.right is None:
                return True
            
            return dfs(now.left, sum) or dfs(now.right, sum)
        
        return dfs(root, 0)