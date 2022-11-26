package linkedlist;

import sun.awt.image.ImageWatched;
import util.SingleNode;



// head -> null
            //100 // 25 -> null
public class LinkedList<E> {

    private SingleNode<E> head;
    private int size;

    LinkedList(){
        size=0;
        this.head=null;
    }



    public int size(){
        return this.size;
    }


    // 15-> 100

    // head -> 100
             //100 // 25 -> null
    public  void addInFront(E data){
        SingleNode<E> newNode = new SingleNode<>(data);
        if (head != null) {
            newNode.next = head;
        }
        head=newNode;
        this.size++;

    }

    public E peek(){
        if(size!=0){
            return this.head.data;
        }
       return  null;
    }

    public  void addInRear(E data){
        SingleNode<E> newNode = new SingleNode<>(data);

        if (head == null) {
            head=newNode;
        }
        else{
            SingleNode<E> temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next= newNode;
        }

        this.size++;
    }

    public E getValueByIndex(int index){

        SingleNode<E> node = getNodeByIndex(index);
        return  node.data;
    }


    public SingleNode<E> getNodeByIndex(int index){

        int counter=0;
        if(size==0){
            return null;
        }
        else{
            SingleNode temp =head;
            while (temp.next!=null && index!=counter){
                temp=temp.next;
                counter++;
            }
            return  temp;
        }
    }

    public void print(){
        SingleNode<E> temp = head;
        while(temp!=null){
            System.out.print("  "+temp.data);
            temp=temp.next;

        }
    }



}
