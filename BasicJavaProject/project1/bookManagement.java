package project1;

class Book {
    String ISBN, title, author;
    boolean available;

    public String toString() {
        return "Book Title: " + title + " ISBN: " + ISBN + " Author name: " + author;
    }

    public boolean available() {
        return available;
    }
}
