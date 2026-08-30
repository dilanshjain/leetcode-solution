class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1;
        ListNode j = list2;
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;
        while (i != null && j != null) {
            if (i.val <= j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }

            k = k.next;

        }

        if (i == null)
            k.next = j;
        else
            k.next = i;
        return dummy.next;

    }
}