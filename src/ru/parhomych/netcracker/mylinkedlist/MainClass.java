package ru.parhomych.netcracker.mylinkedlist;

import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        MyLinkedList<Circle> myLinkedList = new MyLinkedList<>();

        myLinkedList.displayMyLinkedList(); // There's no elements in the list now
        System.out.println("Is my linked list empty after creation? --> " + myLinkedList.isEmpty());
        myLinkedList.insertFirst(new Circle(2,"brown"));
        myLinkedList.insertFirst(new Circle(1,"red"));
        myLinkedList.insertFirst(new Circle(0,"green"));
        System.out.println("Is my linked list empty after insertFirst? --> " + myLinkedList.isEmpty());
        myLinkedList.displayMyLinkedList();

        myLinkedList.add(new Circle(3,"aqua"));
        myLinkedList.add(new Circle(4,"yellow"));
        myLinkedList.add(new Circle(5,"eee"));

        myLinkedList.displayMyLinkedList();

        System.out.println();
        System.out.println("Checking the iterator");

        for (MyLinkedListIterator<Circle> iter = (MyLinkedListIterator<Circle>) myLinkedList.iterator();
                iter.hasNext() ; ){
            System.out.println(iter.next());
        }

        System.out.println();
        System.out.println("Checking forEach");

        for (Circle item : myLinkedList){
            System.out.println(item);
        }

        System.out.println();
        System.out.println("Checking for indexes");

        System.out.println("Size of myLinkedList --> " + myLinkedList.size());
        System.out.println("Size of myLinkedList --> " + myLinkedList.size());

        System.out.println();
        System.out.println("Checking for get");

        System.out.println(".get(0) --> " + myLinkedList.get(0));
        // checking for exception
        // System.out.println(".get(6) --> " + myLinkedList.get(6));

        System.out.println();
        System.out.println("Checking for add(index, element)");

        myLinkedList.add(0, new Circle(0.5, "purple"));
        myLinkedList.add(7, new Circle(7, "blue"));
        myLinkedList.add(3, new Circle(434, "red"));
        // checking for exception
        // myLinkedList.add(10, new Circle(434, "red"));

        myLinkedList.displayMyLinkedList();
        System.out.println("Now size is --> " + myLinkedList.size());

        System.out.println();
        System.out.println("Checking for clear");
        myLinkedList.clear();
        System.out.println("Size of myLinkedList after clear --> " + myLinkedList.size());
        myLinkedList.displayMyLinkedList();

        Circle testPurposeCircle = new Circle(2, "red");
        Circle testPurposeCircle2 = new Circle(2, "red");
        Circle otherCircle = new Circle(20, "brown");

        System.out.println();

        System.out.println(testPurposeCircle + " <-- testPurposeCircle");
        System.out.println(testPurposeCircle2 + " <-- testPurposeCircle2");
        System.out.println(otherCircle + " <-- otherCircle");

        myLinkedList.add(0, new Circle(4,"yellow"));
        myLinkedList.add(testPurposeCircle);
        myLinkedList.add(new Circle(45, "green"));
        myLinkedList.displayMyLinkedList();

        System.out.println("myLinkedList.indexOf(testPurposeCircle) --> " + myLinkedList.indexOf(testPurposeCircle));
        System.out.println("myLinkedList.indexOf(testPurposeCircle2) --> " + myLinkedList.indexOf(testPurposeCircle2));
        System.out.println("myLinkedList.indexOf(other) --> " + myLinkedList.indexOf(otherCircle));
        System.out.println("myLinkedList.indexOf(new Circle(4, \"yellow\")) --> "
                + myLinkedList.indexOf(new Circle(4, "yellow")));

        System.out.println();
        System.out.println("Test for toString");
        System.out.println(myLinkedList);
        myLinkedList.clear();
        System.out.println(myLinkedList);

        System.out.println();
        System.out.println("Test for set()");
        System.out.println("Before set index 1:");
        myLinkedList.add(new Circle(0, "red"));
        myLinkedList.add(new Circle(0, "red"));
        myLinkedList.add(new Circle(0, "red"));
        myLinkedList.displayMyLinkedList();
        myLinkedList.set(1, new Circle(4, "blue"));
        System.out.println("After set index 1:");
        myLinkedList.displayMyLinkedList();

        System.out.println();
        System.out.println("Test for node(1):");
        System.out.println(myLinkedList.node(1));

        System.out.println();
        System.out.println("Test for remove");
        myLinkedList.add(new Circle(34, "tomato"));
        myLinkedList.add(new Circle(24, "pink"));
        myLinkedList.add(new Circle(467, "lime"));
        myLinkedList.displayMyLinkedList();
        myLinkedList.remove(0);
        System.out.println("After remove(0):");
        myLinkedList.displayMyLinkedList();
        myLinkedList.remove(4);
        System.out.println("After remove(4):");
        myLinkedList.displayMyLinkedList();

/*        System.out.println("Test toArray");
        System.out.println(myLinkedList.toArray());*/

        System.out.println("*******************************");
        // MyLinkedList vs LinkedList
        myLinkedList.clear();

        for (int i = 0; i < 10000; i++) {
            myLinkedList.add(Circle.getRandomCircle());
        }

        LinkedList<Circle> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            linkedList.add(Circle.getRandomCircle());
        }

        long startTime, endTime, estimatedTime;
        // add
        startTime = System.nanoTime();

        myLinkedList.add(4000, new Circle(3,"red"));

        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("myLinkedList.add --> " + estimatedTime);

        startTime = System.nanoTime();

        linkedList.add(4000, new Circle(3,"red"));

        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("linkedList.add --> " + estimatedTime);

        // TODO дописать сравнения времени

        // search

        myLinkedList.indexOf(new Circle(3,"red"));

        linkedList.indexOf(new Circle(3,"red"));

        // remove

        myLinkedList.remove(8000);

        linkedList.remove(8000);

    }
}
