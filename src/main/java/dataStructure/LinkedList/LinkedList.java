package dataStructure.LinkedList;

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

    public  boolean isOutOfRange(int index){
        return (index<0 || index >=size());
    }

    public void remove(int index)  {
        if(isOutOfRange(index)){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            head=head.next;
        }
        else
        {
            SingleNode<E> prevNode = getNodeByIndex(index-1);
            if(index==size()-1){
                prevNode.next=null;
            }
            else{

                SingleNode<E> currentNode=prevNode.next;
                prevNode.next=currentNode.next;
                //prevNode.next= prevNode.next.next;
            }
        }

    }
    // home work 29 11 22
//    public boolean contains(E item){
//
//    }
//
//
//    public boolean removeByValue(E item){
//
//    }
//
//    public E pop(){
//
//    }

    public E[] toArray(){

        E[] result = (E[]) new Object[size];
        SingleNode<E> tempNode = this.head;
        for(int i=0 ; i<size; i++){
            E dataAtCurrentNode = tempNode.data;
            result[i]=dataAtCurrentNode;
            tempNode= tempNode.next;
        }
        return result;
    }

    public E getValueByIndex(int index){

        SingleNode<E> node = getNodeByIndex(index);
        if(node!=null){
            return  node.data;
        }
        return null;

    }


    public SingleNode<E> getNodeByIndex(int index){

        int counter=0;
        if(size==0){
            return null;
        }
        else{
            SingleNode<E> temp =head;
            while (temp!=null ){
                if(counter==index){
                    return  temp;
                }
                temp=temp.next;
                counter++;
            }
            return  null;
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
