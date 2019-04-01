package ru.parhomych.netcracker.mylinkedlist;

public interface ILinkedList<E> extends Iterable<E> {

    public void add(E element);
    public void add(int index, E element);
    public void clear();
    public E get(int index);
    public int indexOf(E element);
    public E remove(int index);
    public E set(int index, E element);
    public int size();
    public E[] toArray();
    public String toString();

}
