package com.netcracker.enterprise;

import java.util.Arrays;

public class Book {
    public static class Author {
        private String name;
        private String email;
        private Gender gender;

        public Author() {
            this("Anonymous", "", Gender.UNKNOWN);
        }

        public Author(String name, String email, String gender) {
            this(name, email, Gender.setGender(gender));
        }

        public Author(String name, String email, Gender gender) {
            this.name = name;
            this.email = email;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public Gender getGender() {
            return gender;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setGender(String gender) {
            this.gender = Gender.setGender(gender);
        }

        @Override
        public String toString() {
            return (
                "Author = ( " +
                "name = "     + name + ", " +
                "email = "    + email + ", " +
                "gender = "   + gender.nameLowerCase() +
                " )"
            );
        }
    }

    private final String name;
    private final Author[] authors;
    private double price;
    private int qnt;

    public Book() {
        this("unknown", new Author[]{}, 0.0, 0);
    }

    public Book(String name, Author[] authors, double price) {
        this(name, authors, price, 0);
    }

    public Book(String name, Author[] authors, double price, int qnt) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qnt = qnt;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQnt() {
        return qnt;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return ("Book = { " +
                "name = " + name + ", " +
                "authors = " + Arrays.toString(authors) + ", " +
                "price = " + price + ", " +
                "quantity = " + qnt +
                " }"
        );
    }

    public String getAuthorsNames() {
        StringBuilder names = new StringBuilder();
        boolean first = true;

        for (Author author : authors) {
            if (!first) {
                names.append(", ");
            }
            first = false;

            names.append(author.getName());
        }

        return names.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- 4. Book class ---");

        Author[] a = new Author[] {
                new Author("Author1", "author1@mail.ru", "male"),
                new Author("Author2", "author2@mail.ru", "female"),
                new Author("Author3", "author3@mail.ru", "undecided"),
        };

        Book b = new Book("Name1", a, 1200.);
        System.out.println(b.toString());
        System.out.println(b.getName());
        System.out.println(b.getAuthorsNames());
        System.out.println(Arrays.toString(b.getAuthors()));

        b.setQnt(3);
        System.out.println(b.getQnt());
    }
}