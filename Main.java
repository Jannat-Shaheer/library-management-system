package LMS;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        LibraryBook b1 = new LibraryBook("A", "XYZ", "01", "Fiction");
        LibraryBook b2 = new LibraryBook("B", "ABC", "02", "History");
        System.out.println("Are you member or staff? ");
        String userType = input.next();
        if (userType.equals("member")) {
            System.out.println("Enter name: ");
            String name = input.next();
            System.out.println("Enter ID");
            int id = input.nextInt();
            Members m = new Members(name, id);
            m.options();
            int choice = input.nextInt();
            if (choice == 1) {
                m.display();
            } else if (choice == 2) {
                m.borrow(b1);
            } else if (choice == 3) {
                m.displayBorrowRecord();
            }
        }
        else if (userType.equals("staff"))
        {
            System.out.println("Enter name: ");
            String name = input.next();
            System.out.println("Enter ID");
            int id = input.nextInt();
            Staff s = new Staff(name, id);
            Members m = new Members("Saad", 1);
            s.options();
            int choice = input.nextInt();
            if (choice == 1) {
                s.addBook(b1);
                s.addBook(b2);
                s.display();
            } else if (choice == 2) {
                s.removeBook(b2);
            } else if (choice==3) {
                s.addMembers(m);
            } else if (choice == 4) {
                s.removeMembers(m);
            } else if (choice == 5) {
                s.overdueFine(b1, 14, 50);
            } else if (choice == 6) {
                s.summary();
            }
        }
    }
}