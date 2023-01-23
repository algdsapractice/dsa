public class Node<T> {

    Node<T> next;

    T data ;

    public Node(T data){
        this.data=data;
        this.next=null;
    }

    public Node getNext(){return next;}
    public void setNext(Node<T> node){next=node;}
    public T getData(){return data;}
    public void setData(T data){this.data=data;}



}
