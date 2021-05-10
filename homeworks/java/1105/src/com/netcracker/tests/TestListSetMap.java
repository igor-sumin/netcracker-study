package com.netcracker.tests;

import java.util.*;
import java.util.function.Consumer;

/**
 * Сравним производительности коллекций для основных операций
 */
public class TestListSetMap {
    private static class TestArrayListLinkedList extends TestCollection {
        private final ArrayList<Integer> arrayList = new ArrayList<>();
        private final LinkedList<Integer> linkedList = new LinkedList<>();

        public TestArrayListLinkedList() {
            super();
        }

        public TestArrayListLinkedList(String description, Consumer<Integer> method) {
            super(description, method);
        }

        public void addElements(int size) {
            super.addElements(size, arrayList, linkedList);
        }

        public void searchElements(int size) {
            super.searchElements(size, arrayList, linkedList);
        }

        public void deleteElements(int size) {
            super.deleteElements(size, arrayList, linkedList);
        }

        public void clearElements(int size) {
            super.clearElements(size, arrayList, linkedList);
        }

        /** Вызов тестов для arrayList & linkedList */
        public static void main(String[] args) {
            TestArrayListLinkedList t = new TestArrayListLinkedList();
            TestArrayListLinkedList[] tests = new TestArrayListLinkedList[] {
                    new TestArrayListLinkedList("--- Добавление ---", t::addElements),
                    new TestArrayListLinkedList("--- Поиск ---", t::searchElements),
                    new TestArrayListLinkedList("--- Удаление ---", t::deleteElements),
                    new TestArrayListLinkedList("--- Очистка ---", t::clearElements)
            };

            testing(tests, "ArrayList & LinkedList");
        }
    }

    private static class TestHashSetLinkedHashSetTreeSet extends TestCollection {
        private final HashSet<Integer> hashSet = new HashSet<>();
        private final LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        private final TreeSet<Integer> treeSet = new TreeSet<>();

        public TestHashSetLinkedHashSetTreeSet() {
            super();
        }

        public TestHashSetLinkedHashSetTreeSet(String description, Consumer<Integer> method) {
            super(description, method);
        }

        public void addElements(int size) {
            super.addElements(size, hashSet, linkedHashSet, treeSet);
        }

        public void searchElements(int size) {
            super.searchElements(size, hashSet, linkedHashSet, treeSet);
        }

        public void deleteElements(int size) {
            super.deleteElements(size, hashSet, linkedHashSet, treeSet);
        }

        public void clearElements(int size) {
            super.clearElements(size, hashSet, linkedHashSet, treeSet);
        }

        /** Вызов тестов для hashSet & linkedHashSet & treeSet */
        public static void main(String[] args) {
            TestHashSetLinkedHashSetTreeSet t = new TestHashSetLinkedHashSetTreeSet();
            TestHashSetLinkedHashSetTreeSet[] tests = new TestHashSetLinkedHashSetTreeSet[] {
                    new TestHashSetLinkedHashSetTreeSet("--- Добавление ---", t::addElements),
                    new TestHashSetLinkedHashSetTreeSet("--- Поиск ---", t::searchElements),
                    new TestHashSetLinkedHashSetTreeSet("--- Удаление ---", t::deleteElements),
                    new TestHashSetLinkedHashSetTreeSet("--- Очистка ---", t::clearElements)
            };

            testing(tests, "HashSet & LinkedHashSet & TreeSet");
        }
    }

    private static class TestHashMapLinkedHashMapTreeMap extends TestMap {
        private final HashMap<Integer, Integer> hashMap = new HashMap<>();
        private final LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public TestHashMapLinkedHashMapTreeMap() {
            super();
        }

        public TestHashMapLinkedHashMapTreeMap(String description, Consumer<Integer> method) {
            super(description, method);
        }

        public void addElements(int size) {
            super.addElements(size, hashMap, linkedHashMap, treeMap);
        }

        public void searchElements(int size) {
            super.searchElements(size, hashMap, linkedHashMap, treeMap);
        }

        public void deleteElements(int size) {
            super.deleteElements(size, hashMap, linkedHashMap, treeMap);
        }

        public void clearElements(int size) {
            super.clearElements(size, hashMap, linkedHashMap, treeMap);
        }

        /** Вызов тестов для hashMap & linkedHashMap & treeMap */
        public static void main(String[] args) {
            TestHashMapLinkedHashMapTreeMap t = new TestHashMapLinkedHashMapTreeMap();
            TestHashMapLinkedHashMapTreeMap[] tests = new TestHashMapLinkedHashMapTreeMap[] {
                    new TestHashMapLinkedHashMapTreeMap("--- Добавление ---", t::addElements),
                    new TestHashMapLinkedHashMapTreeMap("--- Поиск ---", t::searchElements),
                    new TestHashMapLinkedHashMapTreeMap("--- Удаление ---", t::deleteElements),
                    new TestHashMapLinkedHashMapTreeMap("--- Очистка ---", t::clearElements)
            };

            testing(tests, "HashMap & LinkedHashMap & TreeMap");
        }
    }

    /** Вызов всех тестов */
    public static void main(String[] args) {
        TestArrayListLinkedList.main(args);
        TestHashSetLinkedHashSetTreeSet.main(args);
        TestHashMapLinkedHashMapTreeMap.main(args);
    }
}