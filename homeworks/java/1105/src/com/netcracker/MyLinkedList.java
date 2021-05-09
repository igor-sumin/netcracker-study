package com.netcracker;

import java.util.Iterator;
import java.util.Random;

public class MyLinkedList<E> implements ILinkedList<E>, Iterable<E> {
    private Node<E> first, last;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next, prev;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.first = this.last = null;
        this.size = 0;
    }

    public MyLinkedList(MyLinkedList<E> mll) {
        this.first = this.last = null;
        this.size = 0;

        for (Node<E> temp = mll.first; temp != null; temp = temp.next) {
            linkLast(temp.item);
        }
    }

    /**
     * Возвращаем полное копирование списка
     */
    @Override
    @SuppressWarnings("unchecked")
    public MyLinkedList<E> clone() throws CloneNotSupportedException {
        MyLinkedList<E> clone = (MyLinkedList<E>) super.clone();

        clone.first = clone.last = null;
        clone.size = 0;

        for (Node<E> node = first; node != null; node = node.next)
            clone.linkLast(node.item);

        return clone;
    }

    /**
     * Проверяем, существует ли данный индекс в списке
     */
    private void isElementIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("invalid index " + index);
        }
    }

    /**
     * Вставляем элемент в начало списка
     */
    public void linkFirst(E element) {
        Node<E> f = this.first;
        Node<E> newNode = new Node<>(element, null, f);
        this.first = newNode;

        if (f == null) {
            this.last = newNode;
        } else {
            f.prev = newNode;
        }

        this.size++;
    }

    /**
     * Вставляем element перед ненулевым node
     */
    public void linkBefore(E element, Node<E> node) {
        assert node != null;

        Node<E> prevNode = node.prev;
        Node<E> tempNode = new Node<>(element, prevNode, node);
        node.prev = tempNode;

        if (prevNode == null) {
            this.first = tempNode;
        } else {
            prevNode.next = tempNode;
        }

        this.size++;
    }

    /**
     * Вставляем элемент в конец списка
     */
    public void linkLast(E element) {
        Node<E> l = this.last;
        Node<E> newNode = new Node<>(element, l, null);
        this.last = newNode;

        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }

        this.size++;
    }

    /**
     * Возвращаем ненулевой node по индексу
     */
    public Node<E> node(int index) {
        isElementIndex(index);

        Node<E> res;

        // смотрим с какой стороны лучше идти (с начала или с конца)
        if (index < (this.size >> 1)) {
            res = this.first;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
        } else {
            res = this.last;
            for (int i = this.size - 1; i > index; i--) {
                res = res.prev;
            }
        }

        return res;
    }

    /**
     * Удаляем ненулевой node, извлекая элемент
     */
    public E unlink(Node<E> node) {
        assert node != null;

        E element = node.item;
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if (prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;

        return element;
    }

    /**
     * Добавляем элемент в конец списка
     */
    @Override
    public void add(E element) {
        linkLast(element);
    }

    /**
     * Добавляем указанный элемент в указанную позицию в списке
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("invalid index " + index);
        }

        if (index == size) {
            linkLast(element);
        } else if (index == 0) {
            linkFirst(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * Удаляем все элементы из этого списка. После этого вызова список будет пустым
     */
    @Override
    public void clear() {
        Node<E> e = this.first;
        while (e != null) {
            Node<E> next = e.next;

            e.item = null;
            e.prev = null;
            e.next = null;

            e = next;
        }

        this.first = this.last = null;
        this.size = 0;
    }

    /**
     * Возвращаем элемент в указанной позиции index в списке
     */
    @Override
    public E get(int index) {
        return node(index).item;
    }

    /**
     * Возвращаем индекс первого вхождения указанного элемента в списке.
     * Если список не содержит элемента - возвращаем -1.
     */
    @Override
    public int indexOf(E element) {
        int k = 0;
        for (Node<E> i = this.first; i != null; i = i.next) {
            if (element.equals(i.item))
                return k;

            k++;
        }

        return -1;
    }

    /**
     * Удаляем элемент в указанной позиции в списке
     */
    @Override
    public E remove(int index) {
        isElementIndex(index);
        return unlink(node(index));
    }

    /**
     * Заменяем элемент в указанной позиции в списке указанным элементом.
     */
    @Override
    public E set(int index, E element) {
        isElementIndex(index);

        Node<E> node = node(index);
        E oldElement = node.item;
        node.item = element;

        return oldElement;
    }

    /**
     * Возвращаем размер списка
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Возвращаем массив, содержащий все элементы в списке в правильной последовательности
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < this.size) {
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size
            );
        }

        int i = 0;
        Object[] result = a;
        for(Node<E> node = this.first; node != null; node = node.next) {
            result[i++] = node.item;
        }

        if (a.length > this.size) {
            a[this.size] = null;
        }

        return a;
    }


    /**
     * Кастомный вариант реализации итератора через анонимный внутренний класс
     */
    @Override
    public Iterator<E> iterator() {
        MyLinkedList<E> list = this;

        return new Iterator<>() {
            Node<E> node = list.first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E temp = node.item;
                node = node.next;

                return temp;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.getClass().getName()).append("[");
        for (Node<E> node = this.first; node != null; node = node.next) {
            if (!node.equals(this.first))
                builder.append(" -> ");

            builder.append(node.item);
        }

        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing MyLinkedList ---");

        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            list1.add(random.nextInt(10));
        }

        System.out.println("list1 (toString): ");
        System.out.println(list1);
        System.out.println();

        MyLinkedList<Integer> list2 = new MyLinkedList<>(list1);
        System.out.println("list2 (before): ");
        System.out.println(list2);

        System.out.println("list2 (remove): [random]");
        for (int i = 0; i < 3; i++) {
            Integer elem = list2.remove(random.nextInt(2));
            System.out.printf("%d ", elem);
        }
        System.out.println();

        System.out.println("list2 (after): ");
        System.out.println(list2);
        System.out.println();

        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list3.add(random.nextInt(10));
        }

        System.out.println("list3 (before): ");
        System.out.println(list3);

        System.out.println("list3 (set): ");
        list3.set(3, 333);
        list3.set(4, 444);
        list3.set(2, 222);

        System.out.println("list3 (indexOf): ");
        System.out.println(list3.indexOf(444));

        System.out.println("list3 (after): ");
        System.out.println(list3);
        System.out.println();

        MyLinkedList<Integer> list4 = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list4.add(random.nextInt(10));
        }

        System.out.println("list4 (before): ");
        System.out.println(list4);

        System.out.println("list4 (clear):");
        list4.clear();
        System.out.println(list4);

        System.out.println("list4 (add): [random]");
        for (int i = 0; i < 5; i++) {
            list4.add(random.nextInt(10));
        }

        for (int i = 0; i < 5; i++) {
            list4.add(random.nextInt(5), 10 + random.nextInt(10));
        }

        System.out.println("list4 (after): ");
        System.out.println(list4);
        System.out.println();

        System.out.println("iterator: ");
        for (Integer integer : list4) {
            System.out.printf("%d ", integer);
        }

        System.out.print("\n--- Testing done. ---");
    }
}