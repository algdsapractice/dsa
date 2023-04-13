package linkedlist;

import dataStructure.LinkedList.SinglyLinkedList;

public class LinkedListProblems {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        System.out.println("Before Reversal");
        list.print();
        reverse(list);
        System.out.println();
        System.out.println("After Reversal");
        list.print();
    }

    private static <T> void reverse(SinglyLinkedList<T> list) {

        SinglyLinkedList<T>.Node  previous=null;
        SinglyLinkedList<T>.Node  next=null;
        SinglyLinkedList<T>.Node  current= list.head;

        while(null!=current){
            next=current.next;
            current.next = previous;
            previous=current;
            current=next;
        }
        list.head = previous;
    }


}
