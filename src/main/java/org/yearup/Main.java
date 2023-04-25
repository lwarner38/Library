package org.yearup;

import java.util.Scanner;

public class Main
{
    static Scanner scanner = new Scanner(System.in);

    static Book[] books = new Book[5];

    static int counter = 0;

    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("Hello welcome");

        createInvetory();

        while (true)
        {
            int selection = displayHomeScreen();

            if(selection == 1)
            {
                displayAvailableBooks();
            } else if (selection == 2)
            {
                displayCheckOutBooks();

            } else if (selection == 3)
            {
                System.out.println();
                System.out.println("Thank you, see you soon.");
                break;
            }
            else {
                System.out.println();
                System.out.println("Invalid option, Try again?");
            }
            System.out.println("----------------------------------");

        }



    }

    private static void createInvetory()
    {
        books[0] = new Book(1,"983-839893-0","Rich Dad, Poor Dad",false,"");
        books[1]= new Book(2,"383-833393-0","The Four Elements",false,"");
        books[2]= new Book(3,"773-833393-0","Stranger",false,"");
        books[3]= new Book(4,"203-637893-0","YOU",false,"");
        books[4]= new Book(5,"383-333893-0","From",false,"");
        counter = 5;
    }

    public static int displayHomeScreen()
    {
        System.out.println();
        System.out.println("Library\n");
        System.out.println("Home");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("Please select a option from below");
        System.out.println("1.) List all available book");
        System.out.println("2.) List all checked out books");
        System.out.println("Exit");
        System.out.println("Please enter your option: ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        return selection;

    }

    public static void displayAvailableBooks()
    {
        System.out.println();
        System.out.println("Available Books: ");
        System.out.println("----------------------------------------------------------");
        System.out.println("ID           ISBN              Title             ");

        for (int i = 0; i < counter; i++)
        {
            Book book = books[i];

            if(!book.isCheckedOut())
            {
                displayBook(book);
            }


        }
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Please select a option from below");
        System.out.println("C - To check out a book");
        System.out.println("X - To return to the Home screen");
        System.out.println("Please enter your option");
        String option = scanner.nextLine().strip();

        if(option.equalsIgnoreCase("C"))
        {
            displayCheckOutBooks();
        }
        else if (option.equalsIgnoreCase("X"))
        {
            displayHomeScreen();


        }


    }
    public static void displayCheckOutBooks() {
        System.out.println();
        System.out.println("Checked Out Books: ");
        System.out.println("----------------------------------------------------------");
        System.out.println("ID           ISBN              Title             ");

        for (int i = 0; i < counter; i++) {
            Book book = books[i];
            if (book.isCheckedOut()) {
                displayBook(book);
            }
        }

        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Please select a option from below");
        System.out.println("C - To check out a book");
        System.out.println("X - To return to the Home screen");
        System.out.println("Please enter your option");
        String option = scanner.nextLine().strip();

        if (option.equalsIgnoreCase("C")) {
            displayCheckInBook();
        } else if (option.equalsIgnoreCase("X")) {
            displayHomeScreen();
        }
    }

    public static void displayCheckOutBook()
    {
        System.out.println();
        System.out.println("What is your name?   ");
        String name = scanner.nextLine().strip();

        System.out.println("Please select the book ID, to begin check out:");
        int input = scanner.nextInt();
        books[input - 1].checkOut(name);
        System.out.println("Check out option complete");
    }

    public static void displayCheckInBook()
    {
        System.out.println();
        System.out.println("Enter the book's ID to check in:  ");
        int input = scanner.nextInt();

        books[input-1].checkIn();

        System.out.println("Check in completed. ");

    }
    public static void displayBook(Book book)
    {
        System.out.println();
        System.out.println(book.getId() + "    " + book.getIsbn() + "    " + book.getTitle());
    }


}