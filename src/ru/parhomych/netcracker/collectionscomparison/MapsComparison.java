package ru.parhomych.netcracker.collectionscomparison;

import ru.parhomych.netcracker.mylinkedlist.Circle;

import java.util.*;

public class MapsComparison {
    public static void main(String[] args) {

        int sizeOfMap = 10000;
        long startTime, endTime, estimatedTime;
        UtilMaps<Integer, Circle> utilMaps = new UtilMaps<>();

        // creating base for comparison elements (value of radius in order of adding)
        Circle[] arrayOfCircles = new Circle[sizeOfMap];
        for (int i = 0; i < arrayOfCircles.length; i++) {
            arrayOfCircles[i] = Circle.getRandomCircle();
            arrayOfCircles[i].setRadius(i);
        }

        // creating keys for maps comparison (mixed)
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        for (int i = 0; i < sizeOfMap; i++) {
            arrayListInt.add(i);
        }
        Collections.shuffle(arrayListInt);

        HashMap<Integer, Circle> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Circle> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Circle> treeMap = new TreeMap<>();

        System.out.println("****************************************");

        // add-filling
        startTime = System.nanoTime();
        for (int i = 0; i < arrayOfCircles.length; i++) {
            hashMap.put(arrayListInt.get(i), arrayOfCircles[i]);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashMap\t\t\t[add-filling] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < arrayOfCircles.length; i++) {
            linkedHashMap.put(arrayListInt.get(i), arrayOfCircles[i]);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[add-filling] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < arrayOfCircles.length; i++) {
            treeMap.put(arrayListInt.get(i), arrayOfCircles[i]);
        }        
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[add-filling] --> " + estimatedTime);
        System.out.println("****************************************");

        // insertion
        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i = i + 3){
            hashMap.put(i, Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashMap\t\t\t[add-insert ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i = i + 3){
            linkedHashMap.put(i, Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[add-insert ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i = i + 3){
            treeMap.put(i, Circle.getRandomCircle());
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[add-insert ] --> " + estimatedTime);
        System.out.println("****************************************");

        // Contains
        Circle circleForContains = new Circle(2, "blue");
        hashMap.put(sizeOfMap/2, circleForContains);
        linkedHashMap.put(sizeOfMap/2, circleForContains);
        treeMap.put(sizeOfMap/2, circleForContains);

        // contains value
        startTime = System.nanoTime();
        System.out.println("Value found? -> " + hashMap.containsValue(circleForContains));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashMap\t\t\t[contains(v)] --> " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Value found? -> " + linkedHashMap.containsValue(circleForContains));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[contains(v)] --> " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Value found? -> " + treeMap.containsValue(circleForContains));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[contains(v)] --> " + estimatedTime);
        System.out.println("****************************************");

        // contains key
        startTime = System.nanoTime();
        System.out.println("Key found? -> " + hashMap.containsKey(sizeOfMap/3));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashMap\t\t\t[contains(k)] --> " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Key found? -> " + linkedHashMap.containsKey(sizeOfMap/3));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[contains(k)] --> " + estimatedTime);

        startTime = System.nanoTime();
        System.out.println("Key found? -> " + treeMap.containsKey(sizeOfMap/3));
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[contains(k)] --> " + estimatedTime);
        System.out.println("****************************************");

        // replace
        startTime = System.nanoTime();
        for (int i = 0; i < hashMap.size(); i++) {
            hashMap.replace(i, circleForContains);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("HashMap\t\t\t[replace    ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < linkedHashMap.size(); i++) {
            linkedHashMap.replace(i, circleForContains);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[replace    ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < treeMap.size(); i++) {
            treeMap.replace(i, circleForContains);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[replace    ] --> " + estimatedTime);
        System.out.println("****************************************");

        // display time
        utilMaps.displayMapTime(hashMap);
        utilMaps.displayMapTime(linkedHashMap);
        utilMaps.displayMapTime(treeMap);

        // remove
        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i++) {
            hashMap.remove(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;

        System.out.println("HashMap\t\t\t[remove     ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i++) {
            linkedHashMap.remove(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("LinkedHashMap\t[remove     ] --> " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < sizeOfMap; i++) {
            treeMap.remove(i);
        }
        endTime = System.nanoTime();
        estimatedTime = endTime - startTime;
        System.out.println("TreeMap\t\t\t[remove     ] --> " + estimatedTime);
        System.out.println("****************************************");


        //display maps after removing
        utilMaps.displayMap(hashMap);
        utilMaps.displayMap(linkedHashMap);
        utilMaps.displayMap(treeMap);

    }
}
