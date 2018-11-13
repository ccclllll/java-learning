package algorithm.datastruct;

public class LinkedList<E> {
    LinkedListNode node;
    int size=0;
    class LinkedListNode {
        E element;
        LinkedListNode next;
    }

    public E get(int i) {
        if (node == null) {
            return null;
        } else {
            int index = 0;
            LinkedListNode indexNode = node;
            while (indexNode != null && index < i) {
                indexNode = indexNode.next;
                index++;
            }
            if (i == index) {
                return indexNode.element;
            }
            return null;
        }
    }

    public E insert(int index, E e) {
        LinkedListNode listNode = new LinkedListNode();
        listNode.element = e;
        if(node == null){
            node = listNode;
        }
        LinkedListNode pre = node;
        int i = 0;

        while (pre != null && i < index-1) {
            pre = pre.next;
            i++;
        }
        if (i == index){
            listNode.next = pre.next;
            pre.next = listNode;
            size++;
        }
        else {
            return null;
        }
        return e;
    }

    public int size(){
        return size;
    }
}
