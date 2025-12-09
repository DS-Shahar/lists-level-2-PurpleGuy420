public class Main {

    public static void main(String[] args)
    {
        int [] a = {1,3,5,7};
        int [] b = {2,4,6,8};
        Node<Integer> list = buildList(a);
        Node<Integer> list2 = buildList(b);
        Node<Integer> list3 = selectionSort(list, list2);
        NodePrint(list3);
    }

    public static Node<Integer> selectionSort(Node<Integer> L1, Node<Integer> L2)
    {
        Node<Integer> p = new Node<Integer>(-1, null);
        Node<Integer> h = p;

        while(L1 != null)
        {
            p.setNext(L1);
            L1 = L1.getNext();
            p = p.getNext();
        }
        p.setNext(L2);

        Node<Integer> combined = h.getNext();

        Node<Integer> dum = new Node<Integer>(-1, null);
        Node<Integer> tail = dum;

        while (combined != null) {
            Node<Integer> prev = null;
            Node<Integer> cur = combined;

            Node<Integer> minPrev = null;
            Node<Integer> minNode = combined;

            // find minimum node and its previous node
            while (cur != null) {
                if (cur.getValue() < minNode.getValue()) {
                    minPrev = prev;
                    minNode = cur;
                }
                prev = cur;
                cur = cur.getNext();
            }

            // remove minNode from combined
            if (minPrev == null) {
                // minNode is at head
                combined = minNode.getNext();
            } else {
                minPrev.setNext(minNode.getNext());
            }

            // append minNode to result (reusing the node)
            minNode.setNext(null);
            tail.setNext(minNode);
            tail = tail.getNext();
        }

        return dum.getNext();
    }

    public static Node<Integer> mergeSorted(Node<Integer> L1, Node<Integer> L2)
    {
        Node<Integer> p = new Node<Integer>(-1, null);
        Node<Integer> h = p;
        while(L1 != null && L2 != null)
        {
            if(L1.getValue()<L2.getValue())
            {
                Node<Integer> temp = new Node<Integer>(L1.getValue(), null);
                p.setNext(temp);
                L1 = L1.getNext();
                p = p.getNext();
            }
            else
            {
                Node<Integer> temp = new Node<Integer>(L2.getValue(), null);
                p.setNext(temp);
                L2 = L2.getNext();
                p = p.getNext();
            }

        }
        if(L1==null)
        {
            p.setNext(L2);
        }
        else
        {
            p.setNext(L1);
        }
        return h.getNext();


    }

    public static Node<Integer> buildList(int [] a)
    {
        Node<Integer> p = new Node<Integer>(a[0]);
        Node<Integer> head = p;

        for(int i = 1; i<a.length; i++)
        {
            Node<Integer> x = new Node<Integer>(a[i]);
            p.setNext(x);
            p=p.getNext();
        }
        return head;
    }

    public static void NodePrint(Node<Integer> list)
    {
        while (list.hasNext()) {
            System.out.println(list.getValue());
            list = list.getNext();
        }
        System.out.println(list.getValue());
    }
}
