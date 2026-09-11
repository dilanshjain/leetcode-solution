
class Solution {

    public Node deepCopy(Node head1) {
        Node temp1 = head1;
        Node head2 = new Node(-1);
        Node temp2 = head2;

        while (temp1 != null) {
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }

        return head2.next;
    }

    public void merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            Node next1 = temp1.next;
            Node next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;

            temp1 = next1;
            temp2 = next2;
        }
    }

    public void randomConnections(Node head1) {
        Node temp1 = head1;

        while (temp1 != null) {
            Node copy = temp1.next;

            if (temp1.random != null) {
                copy.random = temp1.random.next;
            }

            temp1 = copy.next;
        }
    }

    public Node split(Node head1) {
        Node copyHead = head1.next;
        Node temp1 = head1;
        Node temp2 = copyHead;

        while (temp1 != null) {
            temp1.next = temp2.next;

            if (temp1.next != null) {
                temp2.next = temp1.next.next;
            } else {
                temp2.next = null;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return copyHead;
    }

    public Node copyRandomList(Node head1) {
        if (head1 == null) {
            return null;
        }

        Node head2 = deepCopy(head1);
        merge(head1, head2);
        randomConnections(head1);

        return split(head1);
    }
}

