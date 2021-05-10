package com.netcracker.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public abstract class Test {
    private final String description;
    private final Consumer<Integer> method;

    protected final Random random = new Random();
    protected long start, finish;

    protected static ArrayList<ArrayList<String>> DATA = new ArrayList<>();

    protected static final File FILE = new File("src/com/netcracker/analysis", "new.csv");

    public Test() {
        this.description = "";
        this.method = null;
    }

    public Test(String description, Consumer<Integer> method) {
        this.description = description;
        this.method = method;
    }

    public Consumer<Integer> getMethod() {
        return this.method;
    }
    public String getDescription() {
        return this.description;
    }

    /** Запись результатов в CSV-файл */
    public static void writeCSVFiles() {
        ArrayList<String> titles = new ArrayList<>(List.of("Name", "Add", "Search", "Delete", "Clear"));

        try (FileWriter csvWriter = new FileWriter(FILE, StandardCharsets.UTF_8)) {
            boolean first = true;
            for (String title : titles) {
                if (!first) {
                    csvWriter.append(',');
                } first = false;

                csvWriter.append(title);
            }

            csvWriter.append('\n');

            for (ArrayList<String> data : DATA) {
                first = true;
                for (String d : data) {
                    if (!first) {
                        csvWriter.append(',');
                    } first = false;

                    csvWriter.append(d);
                }
                csvWriter.append('\n');
            }

            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}