package ru.parhomych.netcracker.collectionscomparison;

import ru.parhomych.netcracker.mylinkedlist.Circle;

import java.util.*;

public class SetsComparison {
    public static void main(String[] args) {

        long startTime, endTime, estimatedTime;
        // creating base for comparison elements
        Circle[] arrayOfCircles = new Circle[10000];
        for (int i = arrayOfCircles.length - 1; i > -1; i--) {
            arrayOfCircles[i] = Circle.getRandomCircle();
            arrayOfCircles[i].setRadius(i);
        }

        HashSet<Circle> hashSet = new HashSet<>();
        LinkedHashSet<Circle> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Circle> treeSet = new TreeSet<>();

        System.out.println("****************************************");
        // добавление
        startTime = System.nanoTime();
        hashSet.addAll(Arrays.asList(arrayOfCircles));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashSet\t\t\t[add-filling] --> " + estimatedTime);

        startTime = System.nanoTime();
        linkedHashSet.addAll(Arrays.asList(arrayOfCircles));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashSet\t[add-filling] --> " + estimatedTime);

        startTime = System.nanoTime();
        treeSet.addAll(Arrays.asList(arrayOfCircles));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeSet\t\t\t[add-filling] --> " + estimatedTime);
        System.out.println("****************************************");

        // вставка элементов
        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            hashSet.add(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashSet\t\t\t[add-insert ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            linkedHashSet.add(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashSet\t[add-insert ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            treeSet.add(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeSet\t\t\t[add-insert ] --> " + estimatedTime);
        System.out.println("****************************************");


        // Contains
       /* Circle circleForContains = new Circle(2,"blue");
        hashSet.add(circleForContains);
        linkedHashSet.add(circleForContains);
        treeSet.add(circleForContains);*/

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            hashSet.contains(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashSet\t\t\t[contains   ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            linkedHashSet.contains(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashSet\t[contains   ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForInsert = new Circle(i, "insertColor" + i);
            treeSet.contains(circleForInsert);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeSet\t\t\t[contains   ] --> " + estimatedTime);
        System.out.println("****************************************");

        // remove
        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForRemove = new Circle(i, "insertColor" + i);
            hashSet.remove(circleForRemove);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashSet\t\t\t[remove     ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForRemove = new Circle(i, "insertColor" + i);
            linkedHashSet.remove(circleForRemove);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashSet\t[remove     ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 5000; i < 6000; i = i + 3){
            Circle circleForRemove = new Circle(i, "insertColor" + i);
            treeSet.remove(circleForRemove);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeSet\t\t\t[remove     ] --> " + estimatedTime);
        System.out.println("****************************************");



/*        // prints tree set
        for (Circle item : hashSet) {
            System.out.println(item + " Hash: " + item.hashCode());
        }

        System.out.println(hashSet.size());
        System.out.println(linkedHashSet.size());
        System.out.println(treeSet.size());
*/
    }
}
