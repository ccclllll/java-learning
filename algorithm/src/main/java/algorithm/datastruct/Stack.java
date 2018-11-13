package algorithm.datastruct;

import java.util.Arrays;

/**
 * 栈
 * 后进先出
 * */
public class Stack<E> {
    Object[] elementData;
    private int top = -1; // 栈顶元素下标

    private int size = 50;
    public Stack() {
        this.elementData = new Object[50];
    }

    public E push(E element){
        addElement(element);
        return element;
    }

    public void addElement(E e){
        if(top == size-1){
            this.resizeStack();
        }
        elementData[++top] = e;
    }

    public E pop(){
        return (E)elementData[top--];
    }

    public E gettop(){
        return (E)elementData[top];
    }

    public void resizeStack(){
        size+=50;
        this.elementData = Arrays.copyOf(elementData,size);
    }

}
