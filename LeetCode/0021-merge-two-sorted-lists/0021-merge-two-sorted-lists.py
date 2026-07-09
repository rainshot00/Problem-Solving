# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        now = ans

        while list1 or list2:
            if not list1:
                now.next = ListNode(list2.val)
                list2 = list2.next
            elif not list2:
                now.next = ListNode(list1.val)
                list1 = list1.next
            else:
                if list1.val <= list2.val:
                    now.next = ListNode(list1.val)
                    list1 = list1.next
                else:
                    now.next = ListNode(list2.val)
                    list2 = list2.next
            
            now = now.next

        return ans.next