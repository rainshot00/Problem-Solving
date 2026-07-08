# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        c = 0
        ans = ListNode()
        now = ans

        while l1 or l2 or c != 0:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            digit = val1 + val2 + c
            c = digit // 10
            digit = digit % 10

            now.next = ListNode(digit)
            now = now.next

            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        return ans.next
            