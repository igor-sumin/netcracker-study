package com.netcracker.tests;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

public class TestMap extends Test {
    public TestMap() {
        super();
    }

    public TestMap(String description, Consumer<Integer> method) {
        super(description, method);
    }

    /** Очистка коллекций */
    @SafeVarargs
    public final <K, V> void clearCollections(Map<K, V>... maps) {
        for (Map<K, V> map : maps) {
            map.clear();
        }
    }

    /** Вызов тестов */
    public static void testing(TestMap[] tests, String description) {
        System.out.println("\n\n--- Test " + description + " ---");

        int k = 1;
        for (TestMap test : tests) {
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
    public final void addElements(int size, Map<Integer, Integer>... maps) {
        ArrayList<String> addElementsData = new ArrayList<>();

        // добавляем элементы
        for (Map<Integer, Integer> map : maps) {
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                map.put(random.nextInt(10), random.nextInt(100));
            }
            finish = System.nanoTime();

            System.out.print(map.getClass().getName() + ": ");
            System.out.println(finish - start);
            addElementsData.add(finish - start + "");
        }

        DATA.add(addElementsData);
        clearCollections(maps);
    }

    /** Операция поиска элемента */
    @SafeVarargs
    public final void searchElements(int size, Map<Integer, Integer>... maps) {
        ArrayList<String> searchElementsData = new ArrayList<>();

        // заполняем мапу элементами
        for (Map<Integer, Integer> map : maps) {
            for (int i = 0; i < size; i++) {
                map.put(random.nextInt(10), random.nextInt(100));
            }
        }

        // ищем элементы по ключу
        for (Map<Integer, Integer> map : maps) {
            start = System.nanoTime();
            for (int element : new int[] {size - 1, size / 2, size % 2}) {
                map.get(element);
            }
            finish = System.nanoTime();

            System.out.print(map.getClass().getName() + ": ");
            System.out.println(finish - start);
            searchElementsData.add(finish - start + "");
        }

        DATA.add(searchElementsData);
        clearCollections(maps);
    }

    /** Операция удаления элемента */
    @SafeVarargs
    public final void deleteElements(int size, Map<Integer, Integer>... maps) {
        ArrayList<String> deleteElementsData = new ArrayList<>();

        // заполняем мапу элементами
        for (Map<Integer, Integer> map : maps) {
            for (int i = 0; i < size; i++) {
                map.put(random.nextInt(10), random.nextInt(100));
            }
        }

        // удаляем элементы по ключу
        for (Map<Integer, Integer> map : maps) {
            start = System.nanoTime();
            for (int element : new int[] {size - 1, size / 2, size % 2}) {
                map.remove(element);
            }
            finish = System.nanoTime();

            System.out.print(map.getClass().getName() + ": ");
            System.out.println(finish - start);
            deleteElementsData.add(finish - start + "");
        }

        DATA.add(deleteElementsData);
        clearCollections(maps);
    }

    /** Операция очистки коллекции */
    @SafeVarargs
    public final void clearElements(int size, Map<Integer, Integer>... maps) {
        ArrayList<String> clearElementsData = new ArrayList<>();

        // заполняем мапу элементами
        for (Map<Integer, Integer> map : maps) {
            for (int i = 0; i < size; i++) {
                map.put(random.nextInt(10), random.nextInt(100));
            }
        }

        // очищаем мапы
        for (Map<Integer, Integer> map : maps) {
            start = System.nanoTime();
            map.clear();
            finish = System.nanoTime();

            System.out.print(map.getClass().getName() + ": ");
            System.out.println(finish - start);
            clearElementsData.add(finish - start + "");
        }

        DATA.add(clearElementsData);
    }
}