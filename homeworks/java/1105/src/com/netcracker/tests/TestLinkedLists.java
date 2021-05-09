package com.netcracker.tests;

import com.netcracker.MyLinkedList;

import java.util.LinkedList;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Сравнение производительностей MyLinkedList и LinkedList
 */
public class TestLinkedLists {
    private final MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    private final LinkedList<Integer> linkedList = new LinkedList<>();
    private final Random random = new Random();
    private long start, finish;

    private static class Test {
        final String description;
        final Consumer<Integer> method;

        Test(String description, Consumer<Integer> method) {
            this.description = description;
            this.method = method;
        }
    }

    /**
     * Операция добавления
     */
    public void addElements(int size) {
        // добавляем элементы
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myLinkedList.add(random.nextInt(10));
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        // ---

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.addLast(random.nextInt(10));
        }
        finish = System.nanoTime();

        System.out.print("LinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();
        linkedList.clear();
    }

    /**
     * Операция поиска
     */
    public void searchElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
            linkedList.addLast(i);
        }

        // ищем элементы
        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            myLinkedList.indexOf(element);
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        // ---

        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            linkedList.indexOf(element);
        }
        finish = System.nanoTime();

        System.out.print("LinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();
        linkedList.clear();
    }

    /**
     * Операция удаления элемента
     */
    public void deleteElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
            linkedList.addLast(i);
        }

        // удаляем элементы
        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            myLinkedList.remove(element);
        }
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        // ---

        start = System.nanoTime();
        for (int element : new int[] {size - 1, size / 2, size % 2}) {
            linkedList.remove(element);
        }
        finish = System.nanoTime();

        System.out.print("LinkedList: ");
        System.out.println(finish - start);

        myLinkedList.clear();
        linkedList.clear();
    }

    /**
     * Операция очистки списка
     */
    public void clearElements(int size) {
        // заполняем списки
        for (int i = 0; i < size; i++) {
            myLinkedList.add(i);
            linkedList.addLast(i);
        }

        // очищаем списки
        start = System.nanoTime();
        myLinkedList.clear();
        finish = System.nanoTime();

        System.out.print("MyLinkedList: ");
        System.out.println(finish - start);

        // ---

        start = System.nanoTime();
        linkedList.clear();
        finish = System.nanoTime();

        System.out.print("LinkedList: ");
        System.out.println(finish - start);
    }

    /**
     * Вызов всех тестов
     */
    public static void main(String[] args) {
        TestLinkedLists tests = new TestLinkedLists();

        System.out.println("\n\n--- Test MyLinkedList & LinkedList ---");

        Test[] testing = new Test[] {
                new Test("--- Добавление ---", tests::addElements),
                new Test("--- Поиск ---", tests::searchElements),
                new Test("--- Удаление ---", tests::deleteElements),
                new Test("--- Очистка ---", tests::clearElements),
        };

        int k = 1;
        for (Test test : testing) {
            System.out.println(test.description);
            for (int size : new int[] {10_000, 500_000, 4_000_000, 20_000_000}) {
                System.out.println(k++ + ") [size = " + size + "]: ");
                test.method.accept(size);
            }

            System.out.println();
            k = 0;
        }
    }
}