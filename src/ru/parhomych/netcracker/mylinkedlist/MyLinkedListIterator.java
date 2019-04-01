package ru.parhomych.netcracker.mylinkedlist;

import java.util.Iterator;

public class MyLinkedListIterator<E> implements Iterator<E> {

    private Node<E> currentNode;
    private int currentIndex;

    public MyLinkedListIterator(Node<E> firstNode) {
        this.currentNode = firstNode;
        this.currentIndex = 0;
    }


    @Override
    public boolean hasNext() {
        return (currentNode.getNextNode()!=null);
    }

    @Override
    public E next() {
        if (currentIndex != 0){
            currentNode = currentNode.getNextNode();
        }
        currentIndex++;
        return currentNode.getElement();
    }
}
