package ru.parhomych.netcracker.collectionscomparison;

import ru.parhomych.netcracker.mylinkedlist.Circle;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListsComparison {

    public static void main(String[] args) {
        ArrayList<Circle> circleArrayList = new ArrayList<>();
        LinkedList<Circle> circleLinkedList = new LinkedList<>();
        int sizeOfList = 100000;
        long startTime, endTime, estimatedTime;

        // filling the lists
        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfList; i++){
            circleArrayList.add(Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("filling ArrayList with "+ sizeOfList +" elements [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfList; i++){
            circleLinkedList.add(Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("filling LinkedList with "+ sizeOfList +" elements [LL] --> " + estimatedTime);

        // adding elements
        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfList; i = i + sizeOfList/1000){
            circleArrayList.add(i, Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("adding elements in the middle of ArrayList [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfList; i = i + sizeOfList/1000){
            circleLinkedList.add(i, Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("adding elements in the middle of LinkedList--> [LL] " + estimatedTime);

        Circle circleToFind = new Circle(2, "red");
        circleArrayList.add(sizeOfList/10*9, circleToFind);
        circleLinkedList.add(sizeOfList/10*9, circleToFind);

        // contains
        startTime = System.nanoTime();
        circleArrayList.contains(new Circle(2, "red"));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("contains element near the end [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        circleLinkedList.contains(new Circle(2, "red"));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("contains element near the end [LL] --> " + estimatedTime);

        // indexOf
        startTime = System.nanoTime();
        circleArrayList.indexOf(new Circle(2, "red"));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("indexOf element near the end [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        circleLinkedList.indexOf(new Circle(2, "red"));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("indexOf element near the end [LL] --> " + estimatedTime);

        // get in the middle
        startTime = System.nanoTime();
        for (int i = 0; i < circleArrayList.size(); i = i + 1){
            circleArrayList.get(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("get in the middle of ArrayList [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < circleLinkedList.size(); i = i + 1){
            circleLinkedList.get(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("get in the middle of LinkedList [LL] --> " + estimatedTime);

        // remove an element in the middle of lists
        startTime = System.nanoTime();
        for (int i = circleLinkedList.size() - 1; i > 0 ; i = i - 1){
            circleArrayList.remove(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("removing elements one by one in ArrayList [AL] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = circleLinkedList.size() - 1; i > 0 ; i = i - 1){
            circleLinkedList.remove(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("removing elements one by one in LinkedList [LL] --> " + estimatedTime);

    }
}
