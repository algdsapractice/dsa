package stack;
//1->3->4
//3
import util.SingleNode;

import java.util.EmptyStackException;

public class Stack<E> {

    protected SingleNode<E> top;
    protected int size;
    public Stack(){
        this.size=0;
        this.top=null;
    }

    public void clear(){
        this.top=null;
        this.size=0;
    }
    public void push(E data){
        SingleNode<E> newNode =new SingleNode<>(data);
        if (!isEmpty()) {
            newNode.next = top;
        }
        this.top=newNode;
        this.size++;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return this.top.data;
    }

    public int getSize(){
        return this.size;
    }
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E data = this.top.data;
        this.top=top.next;
        this.size--;

        return data;
    }
    private boolean isEmpty() {
        return this.size==0;
    }


}
