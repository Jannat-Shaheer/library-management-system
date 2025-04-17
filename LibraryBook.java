package LMS;
public class LibraryBook extends Book
{
     public LibraryBook(String title, String author, String id, String category)
     {
          setTitle(title);
          setAuthor(author);
          setId(id);
          setAvailable(true);
          setCategory(category);
     }
}
