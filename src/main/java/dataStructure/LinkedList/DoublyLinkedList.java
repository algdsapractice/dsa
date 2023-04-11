package dataStructure.LinkedList;
public class DoublyLinkedList<T> {

    class Node {
        private Node previous;
        private Node next;
        private T data;

        Node(T data){
            this.data=data;
        }
    }


    private Node head;
    private int size;


    public void print(){
        Node temp = this.head;

        while(null!=temp){
            System.out.print(temp.data + "<->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    private void add(T data){

        Node newNode = new Node(data);

        if(null!=head){

            newNode.next=this.head;
            this.head.previous= newNode;
        }

        this.head = newNode;
        size++;
    }


    private void delete(T data){

        Node currNode = this.head;

        if(null!=head && head.data.equals(data)){
            head=head.next;
            head.previous =null;
        }

        while(null!=currNode){

            if(currNode.data.equals(data)){

                currNode.previous.next= currNode.next;
                currNode.next.previous= currNode.previous;

                return;
            }
            currNode = currNode.next;
            size--;

        }

    }



    public static void main(String[] args) {

        DoublyLinkedList dList= new DoublyLinkedList();
        dList.add(3);
        dList.add(4);
        dList.add(9);
        dList.print();
        dList.delete(4);
        System.out.println();
        dList.print();

        System.out.println();
    }

}