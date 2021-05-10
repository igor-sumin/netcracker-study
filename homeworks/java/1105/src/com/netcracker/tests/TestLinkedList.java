package com.netcracker.tests;

import com.netcracker.MyLinkedList;

import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Сравнение производительностей MyLinkedList и LinkedList
 */
public class TestLinkedList extends TestCollection {
    private final MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    private final LinkedList<Integer> linkedList = new LinkedList<>();

    public TestLinkedList() {
        super();
    }

    public TestLinkedList(String description, Consumer<Integer> method) {
        super(description, method);
    }

    public void addElements(int size) {
        // добавляем элементы
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myLinkedList.add(random.nextInt(10));
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();

        // ---

        super.addElements(size, linkedList);
    }

    public void searchElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
        }

        // ищем элементы
        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            myLinkedList.indexOf(element);
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();

        // ---

        super.searchElements(size, linkedList);
    }

    public void deleteElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
        }

        // удаляем элементы
        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            myLinkedList.remove(element);
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();

        // ---

        super.deleteElements(size, linkedList);
    }

    public void clearElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
        }

        // очищаем списки
        start = System.nanoTime();
        myLinkedList.clear();
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        // ---

        super.clearElements(size, linkedList);
    }

    public static void main(String[] args) {
        TestLinkedList t = new TestLinkedList();
        TestCollection[] tests = new TestCollection[] {
                new TestCollection("--- Добавление ---", t::addElements),
                new TestCollection("--- Поиск ---", t::searchElements),
                new TestCollection("--- Удаление ---", t::deleteElements),
                new TestCollection("--- Очистка ---", t::clearElements)
        };

        testing(tests, "MyLinkedList & LinkedList");
    }
}