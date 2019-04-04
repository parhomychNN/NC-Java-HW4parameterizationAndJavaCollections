package ru.parhomych.netcracker.collectionscomparison;

import ru.parhomych.netcracker.mylinkedlist.Circle;

import java.util.HashMap;
import java.util.Map;

public class UtilMaps<K, V> {

    public void displayMap(Map<K, V> map) {
        System.out.println("**********************************************");
        System.out.println(map.getClass().getSimpleName() + ":");
        for (Map.Entry<K, V> entry :
                map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            System.out.println("Key --> " + key + ". Value --> " + value);
        }


        System.out.println("Size --> " + map.size());
        System.out.println("**********************************************");
    }

    public void displayMapTime(Map<K, V> map) {
        System.out.println("**********************************************");
        System.out.print(map.getClass().getSimpleName() + " display time --> \t");
        long start = System.nanoTime();
        for (Map.Entry<K, V> entry :
                map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
        }
        long end = System.nanoTime();
        long estimatedTime = end - start;

        System.out.print(estimatedTime);
        System.out.println();
        System.out.println("**********************************************");
    }

}
