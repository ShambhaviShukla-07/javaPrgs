package project1;

import java.util.*;
import java.util.function.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class library {
    public static void main(String args[]) {
        ArrayList<Book> AL = new ArrayList<>();
        ArrayList<Student> stu = new ArrayList<>();
        ArrayList<Faculty> teach = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number of books to be added to the library:");
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter the details of book: ");
                Book book = new Book();
                System.out.println("Enter the ISBN of the book: ");
                book.ISBN = br.readLine();
                book.available = true;
                System.out.println("Enter the title of the book: ");
                book.title = br.readLine();
                System.out.println("Enter the author: ");
                book.author = br.readLine();
                AL.add(book);
            }
            // Travering using for each loop
            System.out.println("This is the list of books available in the library:");
            for (Book b : AL) {
                System.out.println("Book Title : " + b.title + " ISBN : " + b.ISBN + " Author name: " + b.author);
            }
            System.out.println("Enter the title of the book that is being issued:");
            String titleMatch = br.readLine();
            System.out.println("Enter the author name of the book that is being issued:");
            String authorMatch=br.readLine();
            Predicate<Book> filterPredicate=book->book.title.contains(titleMatch)&&book.author.contains(authorMatch);
            ArrayList<Book> filterBook=new ArrayList<>();
            for(Book b:AL){
                if(filterPredicate.test(b)){
                    filterBook.add(b);
                }
            }
            System.out.println("Search Results:");
            for(Book b:filterBook){
                System.out.println(b);
            }

            Consumer<Book> printAvailable=book->System.out.println("Title:"+book.title+" Author:"+book.author+" ISBN:"+book.ISBN);
            for(Book b:AL){
                if(b.available())
                    printAvailable.accept(b);
            }
            boolean issued = false;
            for (int i = 0; i < AL.size(); i++) {
                if (AL.get(i).title.equals(titleMatch)) {
                    AL.remove(i);
                    issued = true;
                    break;
                }
            }
            if (issued == true) {
                System.out.println("The issued book has title: " + titleMatch);
                System.out.println("These are the books left in the library: " + AL);
            } else {
                System.out.println("The book with title " + titleMatch + " is not available :(");
            }
            System.out.println("Books left in the library:");
            for (Book b : AL) {
                System.out.println(b);
            }
            System.out.println("Enter the number of student users:");
            int sc = Integer.parseInt(br.readLine());
            for (int i = 1; i <= sc; i++) {
                System.out.println("Enter the name of student " + i);
                String username = br.readLine();
                System.out.println("Enter student ID: ");
                int userID = Integer.parseInt(br.readLine());
                System.out.println("Enter course: ");
                String course = br.readLine();

                stu.add(new Student(username, userID, course));
            }
            // Travering using for each loop
            System.out.println("This is the list of student users:");
            for (Student s : stu) {
                System.out.println(s);
            }

            System.out.println("Enter the number of faculty users:");
            int fc = Integer.parseInt(br.readLine());
            for (int i = 1; i <= fc; i++) {
                System.out.println("Enter the name of faculty " + i);
                String username = br.readLine();
                System.out.println("Enter faculty ID: ");
                int userID = Integer.parseInt(br.readLine());
                System.out.println("Enter subject specialization: ");
                String subject = br.readLine();

                teach.add(new Faculty(username, userID, subject));
            }
            // Travering using for each loop
            System.out.println("This is the list of faculty users:");
            for (Faculty f : teach) {
                System.out.println(f);
            }

        } catch (IOException e) {
            System.out.println("An unexpected error occured:");
            e.printStackTrace();
        }
    }
}
