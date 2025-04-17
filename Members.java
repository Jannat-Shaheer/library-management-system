package LMS;
import java.util.Date;
import java.util.ArrayList;
abstract class User
{
    String name;
    int id;
    public ArrayList<LibraryBook> bookRecord = new ArrayList<>();
    public void display() {
        System.out.println("Books are: " + bookRecord);
    }
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getMemberId() {
        return id;
    }
    Date borrow ;
    Date Return;

    ArrayList<LibraryBook> borrowedBooks = new ArrayList<>();
    private ArrayList<Date> borrowDate = new ArrayList<>();
    private ArrayList<LibraryBook> borrowRecord = new ArrayList<>();
    private ArrayList<LibraryBook> returnRecord = new ArrayList<>();
    private ArrayList<Date> returnDate = new ArrayList<>();
    public void borrow (LibraryBook b)
    {
        borrow = new Date();
        borrowRecord.add(b);
        borrowDate.add(borrow);
        borrowedBooks.add(b);
    }
    public void returnBook (LibraryBook b)
    {
        Return = new Date();
        borrowedBooks.remove(b);
        returnRecord.add(b);
        returnDate.add(Return);
    }
    public long getOverdueTime()
    {
        return (Return.getTime() - borrow.getTime())/86400000; //to return no of days
    }
    public void displayBorrowRecord()
    {
        System.out.println("Borrow record: " + borrowRecord);
    }
    public void displayBorrowDate()
    {
        System.out.println("Borrow date: " + borrowDate);
    }
    public void displayReturnRecord()
    {
        System.out.println("Return record: " + returnRecord);
    }
    public void displayReturnDate()
    {
        System.out.println("Return date: " + returnDate);
    }
    abstract void options();
}
class Staff extends User
{
    ArrayList <Members> membersList = new ArrayList<>();
    ArrayList<LibraryBook> overdueBooks = new ArrayList<>();
    public Staff(String name, int id)
    {
        super(name, id);
    }
    public void addMembers(Members m)
    {
        membersList.add(m);
    }
    public void removeMembers (Members m)
    {
        membersList.remove(m);
    }
    public void addBook(LibraryBook b) {
        bookRecord.add(b);
    }
    public void removeBook(LibraryBook b) {
        bookRecord.remove(b);
    }
    public void update(String bookId, boolean availability)
    {
        for (LibraryBook book : bookRecord)
        {
            if (book.getId().equals(bookId))
            {
                book.setAvailable(availability);
                System.out.println("Updated availability of " + bookId + " is " + availability );
                return;
            }
        }
        //If book with given id doesnt exist in arraylist
        System.out.println("Book with ID " + bookId + " is not found");
    }
    public double overdueFine(LibraryBook b, int maxDays, double fine)
    {   
        if (getOverdueTime()>maxDays)
        {
            overdueBooks.add(b);
            return (maxDays-getOverdueTime())*fine;
        }
        else
        {
            return 0;
        }
    }
    public void booksByCategory(String category)
    {
        ArrayList<LibraryBook> bookCategory = new ArrayList<>();
        int num = 0;
        for (LibraryBook book : bookRecord)
        {
            if (book.getCategory().equals(category))
            {
                num++;
                bookCategory.add(book);
            }
        }
        System.out.println("Number of Books of category " + category + " " + num + ": " + bookCategory);
    }
    public void borrowBookReport()
    {
        System.out.println("Borrowed books: " + borrowedBooks);
    }
    public void summary()
    {
        System.out.println("Total books = " + bookRecord.size() + ", Total members = " + membersList.size());
    }
    public void options()
    {
        System.out.println("Enter action to perform: ");
        System.out.println("1. Add book\n2. Remove book\n3. Add members\n4. Remove members\n5. Calculate fine\n6. Report");
    }
}
class Members extends User
{
    public Members(String name, int id)
    {
        super(name, id);
    }
    public String toString()
    {
        return "Member name: " + getName() + "\nMember ID: " + getMemberId();
    }
    public void options()
    {
        System.out.println("Enter action to perform: ");
        System.out.println("1. View books\n2. Borrow book\n3. View history\n4. Exit");
    }
}



