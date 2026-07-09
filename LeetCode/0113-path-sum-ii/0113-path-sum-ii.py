# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(now, sum, res):
            sum += now.val
            res.append(now.val)

            if now.left is None and now.right is None and sum == targetSum:
                ans.append(res[:])
            
            if now.left is not None:
                dfs(now.left, sum, res)
            if now.right is not None:
                dfs(now.right, sum, res)
            
            sum -= now.val
            res.pop()
        
        if root is None:
            return []
        
        ans = []
        dfs(root, 0, [])

        return ans