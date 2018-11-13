package algorithm.datastruct;

/**
 * 链队列的实现
 * @param <E>
 */
public class LinkedQueue<E> {

    /**
     * 节点定义
     */
    class LinkedQueueNode{
        public E element;
        LinkedQueueNode next;
    }

    LinkedQueueNode head;
    LinkedQueueNode rear;
    private int size = 0;

    public E getHead(){
        if(isEmpty()){
            return null;
        }else {
            return head.element;
        }
    }

    public E enterQueue(E e){
        LinkedQueueNode node = new LinkedQueueNode();
        node.element = e;
        if(isEmpty()){
            head = rear = node;
            head.next = rear;
        }else {
            rear.next = node;
            rear = node;
        }
        size++;
        return node.element;
    }

    public E deleteQueue(){
        if(head.equals(rear)){
            head = rear =null;
            return null;
        }
        E e = head.element;
        head = head.next;
        size--;
        return e;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }
}
