package dataStructure.LinkedList;

public class SinglyLinkedList<T>{


    public class Node
    {
       public T data;
       public Node next;

        public Node(T data){
            this.data = data;
        }
    }


    public Node head;
    public int size;


    public boolean isEmpty(){
        if (null==head){
            return true;
        }

        return false;
    }


    public void print(){

        if(isEmpty()){
            System.out.println("List is empty");
        }

        Node temp = head;
        while(null!=temp){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.print("null");
    }


    // Linked List insertion

    public void add(T data){

        Node newNode= new Node(data);

        if(null!=head){
            newNode.next=head;
        }
        head=newNode;
        size++;
    }


    public void addLast(T data){

        Node newNode = new Node(data);

        Node temp=head;

        while(null!=temp.next){
            temp=temp.next;
        }

        temp.next=newNode;
        size++;

    }


    public void insertAtIndex(int index, T data){
        Node newNode = new Node(data);
        Node temp=head;
        for(int i=0; i<index-1;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }


    public void delete(T data){

        Node curr = head;
        Node previous;

        if(null!=curr && curr.data.equals(data)){
            head=curr.next;
            return;
        }

        while(null!=curr){
            previous = curr;
            curr=curr.next;
            if(null!=curr && curr.data.equals(data)){
                previous.next = curr.next;
                return;
            }

        }


    }

    public boolean isPresent(T data){

        Node temp = this.head;
        while(null!=temp){

            if(temp.data.equals(data)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList();
        list.add(5);
        list.add(4);
        list.add(6);
        list.print();
        list.addLast(9);
        System.out.println("\n Add node at Last");
        list.print();
        list.insertAtIndex(2,12);
        System.out.println("\n Add node at Index");
        list.print();
        System.out.println();
        System.out.println("isPresent  "+list.isPresent(4));
        System.out.println("isPresent  "+list.isPresent(10));
        list.delete(6);
        list.print();
        System.out.println();
        list.delete(5);
        list.print();
        System.out.println();
        list.delete(9);
        list.print();
    }


}


