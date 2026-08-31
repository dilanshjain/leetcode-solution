
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);
        ListNode t1 = d1;
        ListNode t2 = d2;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x ){
                t1.next = temp;
                t1 = t1.next;
            }

            else{
                t2.next = temp;
                t2 = t2.next;
            }

            temp = temp.next;

        }
        t1.next = d2.next;
        t2.next = null;
        return d1.next;
    }
}