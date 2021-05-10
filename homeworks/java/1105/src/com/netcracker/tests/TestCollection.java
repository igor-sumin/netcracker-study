package com.netcracker.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;

public class TestCollection extends Test {
    public TestCollection() {
        super();
    }

    public TestCollection(String description, Consumer<Integer> method) {
        super(description, method);
    }

    /** Очистка коллекций */
    @SafeVarargs
    public final <E> void clearCollections(Collection<E>... collections) {
        for (Collection<E> collection : collections) {
            collection.clear();
        }
    }

    /** Вызов тестов */
    public static void testing(TestCollection[] tests, String description) {
        System.out.println("\n\n--- Test " + description + " ---");

        int k = 1;
        for (TestCollection test : tests) {
            System.out.println(test.getDescription());
            for (int size : new int[] {10_000, 500_000, 4_000_000, 20_000_000}) {
                System.out.println(k++ + ") [size = " + size + "]: ");
                test.getMethod().accept(size);
            }

            System.out.println();
            k = 0;
        }
    }

    /** Операция добавления элемента */
    @SafeVarargs
    public final void addElements(int size, Collection<Integer>... collections) {
        ArrayList<String> addElementsData = new ArrayList<>();

        // добавляем элементы
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                collection.add(random.nextInt(10));
            }
            finish = System.nanoTime();

            System.out.print(collection.getClass().getName() + ": ");
            System.out.println(finish - start);

            addElementsData.add(finish - start + "");
        }

        DATA.add(addElementsData);
        clearCollections(collections);
    }

    /** Операция поиска элемента */
    @SafeVarargs
    public final void searchElements(int size, Collection<Integer>... collections) {
        ArrayList<String> searchElementsData = new ArrayList<>();

        // заполняем коллекции элементами
        for (Collection<Integer> collection : collections) {
            for (int i = 0; i < size; i++) {
                collection.add(i);
            }
        }

        // ищем элементы
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            for (int element : new int[] {size - 1, size / 2, size % 2}) {
                assert collection.stream().anyMatch(num -> num.equals(element));
            }
            finish = System.nanoTime();

            System.out.print(collection.getClass().getName() + ": ");
            System.out.println(finish - start);

            searchElementsData.add(finish - start + "");
        }

        DATA.add(searchElementsData);
        clearCollections(collections);
    }

    /** Операция удаления элемента */
    @SafeVarargs
    public final void deleteElements(int size, Collection<Integer>... collections) {
        ArrayList<String> deleteElementsData = new ArrayList<>();

        // заполняем коллекции элементами
        for (Collection<Integer> collection : collections) {
            for (int i = 0; i < size; i++) {
                collection.add(i);
            }
        }

        // удаляем элементы
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            for (int element : new int[] {size - 1, size / 2, size % 2}) {
                collection.remove(element);
            }
            finish = System.nanoTime();

            System.out.print(collection.getClass().getName() + ": ");
            System.out.println(finish - start);
            deleteElementsData.add(finish - start + "");
        }

        DATA.add(deleteElementsData);
        clearCollections(collections);
    }

    /** Операция очистки коллекции */
    @SafeVarargs
    public final void clearElements(int size, Collection<Integer>... collections) {
        ArrayList<String> clearElementsData = new ArrayList<>();

        // заполняем коллекции элементами
        for (Collection<Integer> collection : collections) {
            for (int i = 0; i < size; i++) {
                collection.add(i);
            }
        }

        // очищаем коллекции
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            collection.clear();
            finish = System.nanoTime();

            System.out.print(collection.getClass().getName() + ": ");
            System.out.println(finish - start);
            clearElementsData.add(finish - start + "");
        }

        DATA.add(clearElementsData);
    }
}