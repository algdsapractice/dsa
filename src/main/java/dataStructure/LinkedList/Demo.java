package dataStructure.LinkedList;

import dataStructure.LinkedList.LinkedList;

public class Demo {

    public static void main(String[] args) {

        // Add Elements to linked list
        LinkedList<Integer> list = new LinkedList<>();
        list.addInFront(1);
        list.addInFront(2);
        list.addInFront(3);
        list.addInRear(10);
        list.addInRear(50);

        System.out.println("Linked list");
        list.print();
        System.out.println();
        System.out.println("Size of Linked List "+ list.size());
        System.out.println("Position of Data    "+ list.getValueByIndex(4));


        System.out.println(list.toArray());
        // hw 29 11 22
        // print the array element


//        list.remove(2);
//        list.print();
//        System.out.println();
//        list.remove(0);
//        list.print();
//        System.out.println();
//        list.remove(2);
//        list.print();
//        System.out.println();
//        list.remove(5);
    }
}
