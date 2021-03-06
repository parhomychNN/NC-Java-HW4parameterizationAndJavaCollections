package ru.parhomych.netcracker.mylinkedlist;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> firstNode;
    private MyLinkedListIterator<E> iterator;
    private int currentIndex = 0;

    public MyLinkedList() {
        this.firstNode = null;
    }

    public boolean isEmpty(){
        return (firstNode==null);
    }

    public void insertFirst(E newFirstElement){
        Node<E> newNode = new Node<>(newFirstElement);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
    }

    public void displayMyLinkedList(){
        if (firstNode!=null){
            System.out.println();
            System.out.println("My linked list contains:");
            for(E item : this){
                System.out.println(item);
            }
        } else {
            System.out.println("There are no any elements!");
        }
        System.out.println();
    }

    @Override
    public void add(E element) {
        if (firstNode!=null){
            Node<E> currentNode = firstNode;
            while (currentNode.getNextNode()!=null){
                currentNode = currentNode.getNextNode();
            }
            Node<E> nodeForAdding = new Node<>(element);
            nodeForAdding.setNextNode(null);
            currentNode.setNextNode(nodeForAdding);
        } else {
            insertFirst(element);
        }
    }

    @Override
    public void add(int index, E element) {
        if (size() == index){
            add(element);
            return;
        }
        if (index == 0){
            insertFirst(element);
            return;
        }
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException();
        }

        Node<E> beforeNode = firstNode;
        for(int i = 0; i < index - 1; i++){
            beforeNode = beforeNode.getNextNode();
        }
        Node<E> nextNode = beforeNode.getNextNode();
        Node<E> nodeForAdding = new Node<>(element);
        beforeNode.setNextNode(nodeForAdding);
        nodeForAdding.setNextNode(nextNode);
    }

    @Override
    public void clear() {
        for (Node<E> x = firstNode; x != null; ) {
            Node<E> next = x.getNextNode();
            x.setElement(null);
            x.setNextNode(null);
            x = next;
        }
        firstNode = null;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        assert isElementIndex(index);
        if (isElementIndex(index)){
            Node<E> x = firstNode;
            for (int i = 0; i < index; i++){
                x = x.getNextNode();
            }
            return x.getElement();
        }
        throw new IndexOutOfBoundsException();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }


    @Override
    public int indexOf(E element) {
        int i = 0;
        for (Node<E> currentNode = firstNode; currentNode.getNextNode() != null; ){
            if (currentNode.getElement().equals(element)){
                return i;
            }
            i = i + 1;
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        int listSize = size();
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToRemove;
        E elementToReturn = null;
        if (index == 0){
            nodeToRemove = firstNode;
            firstNode = firstNode.getNextNode();
            nodeToRemove.setNextNode(null);
        } else if (index == listSize-1) {
            node(listSize-2).setNextNode(null);
        } else {
            Node<E> nodeBeforeRemove = node(index-1);
            nodeToRemove = nodeBeforeRemove.getNextNode();
            Node<E> nodeAfterRemove = nodeToRemove.getNextNode();
            elementToReturn = nodeToRemove.getElement();
            nodeBeforeRemove.setNextNode(nodeAfterRemove);
            nodeToRemove.setNextNode(null);
        }

        return elementToReturn;
    }

    public Node<E> node(int index){
        if (isElementIndex(index)){
            Node<E> currentNode = firstNode;
            if (index == 0){
                return currentNode;
            } else {
                for(int i = 0; i < index; i++){
                    currentNode = currentNode.getNextNode();
                }
            }
            return currentNode;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        if (firstNode != null){
            if (this.isElementIndex(index)){
                Node<E> currentNode = firstNode;
                for (int i = 0; i < index; i++){
                    currentNode = currentNode.getNextNode();
                }
                currentNode.setElement(element);
                return currentNode.getElement();
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            if (index == 0){
                this.insertFirst(element);
                return this.firstNode.getElement();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public int size() {
        currentIndex = 0;
        if (this.isEmpty()){
            return 0;
        } else {
            for (E item : this) {
                currentIndex++;
            }
        }
        return currentIndex;
    }

    @Override
    public E[] toArray() {
        Object[] result = new Object[size()];
        int i = 0;
        for (Node<E> x = firstNode; x != null; x = x.getNextNode())
            result[i++] = x.getElement();
        return (E[]) result;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size())
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size());
        int i = 0;
        Object[] result = a;
        for (Node<E> x = firstNode; x != null; x = x.getNextNode())
            result[i++] = x.getElement();

        if (a.length > size())
            a[size()] = null;

        return a;
    }

    @Override
    public Iterator<E> iterator() {
        iterator = new MyLinkedListIterator<>(firstNode);
        return iterator;
    }

    @Override
    public String toString() {
        if (firstNode == null){
            return "**************\nEmpty MyLinkedList\n***************";
        }
        return "*************\n" +
                "MyLinkedList of " +
                this.size() + " elements. \n" +
                "Type of elements: " + firstNode.getElement().getClass().getSimpleName() + "\n" +
                "************\n";
    }
}
