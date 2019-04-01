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
        for (int i = 0; i < this.size(); i++){
            if(this.get(i).equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        /*if (firstNode != null){
            if (this.isElementIndex(index)){
                int currentIndex = 0;
                Node<E> currentNode = firstNode;
                while (!element.equals(currentNode.getElement()) || currentIndex < size()){
                    currentNode = currentNode.getNextNode();
                }
                if (currentIndex == null )
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            if (index == 0){
                this.insertFirst(element);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }*/
        return null;
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
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        iterator = new MyLinkedListIterator<>(firstNode);
        return iterator;
    }
}
