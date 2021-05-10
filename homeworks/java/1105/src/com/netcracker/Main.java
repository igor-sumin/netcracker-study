package com.netcracker;

import com.netcracker.tests.*;

/**
 * Copyright 2021 Sumin Igor
 */
public class Main {
    public static void main(String[] args) {
//        MyLinkedList.main(args);        // 1 задание    : тестирование моей коллекции
//        TestLinkedList.main(args);      // 2 задание (a): сравнительный анализ связных списков
        TestListSetMap.main(args);      // 2 задание (b, c): сравнительный анализ основных Java коллекций

        Test.writeCSVFiles();
        System.out.println("done.");
    }
}