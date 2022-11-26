package linkedlist;

import util.SingleNode;

public class Demo {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addInFront(1);
        list.addInFront(2);
        list.addInFront(3);
        list.addInRear(10);
        list.addInRear(50);

        System.out.println("Linked list");
        list.print();
        System.out.println();
        System.out.println("Size of Linked List"+ list.size());
        System.out.println("Position of Data"+ list.getValueByIndex(10));
    }
}
