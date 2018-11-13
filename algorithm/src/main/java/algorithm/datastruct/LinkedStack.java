package algorithm.datastruct;

/**
 * 链栈实现
 *
 * @param <E>
 */
public class LinkedStack<E> {

    LinkedStackNode top;
    private int size = 0;

    public E push(E e) {
        size++;
        LinkedStackNode node = new LinkedStackNode(e, top);
        top = node;
        return e;
    }

    public E pop() {
        E e = null;
        if(!isEmpty()){
            e = top.element;
            top = top.pre;
        }
        size--;
        return e;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public E getTop() {
        if (!isEmpty())
            return top.element;
        else
            return null;
    }

    /**
     * 节点
     */
    public class LinkedStackNode {
        public E element; // 数据区域
        public LinkedStackNode pre; // 前一个节点

        public LinkedStackNode(E element, LinkedStackNode pre) {
            this.element = element;
            this.pre =pre;
        }
    }
}
