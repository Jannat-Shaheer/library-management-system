package LMS;
public abstract class Book
{
     private String title;
     private String author;
     private String id;
     private boolean available;
     private String category;
     public void setTitle(String title)
     {
          this.title = title;
     }
     public String getTitle()
     {
          return title;
     }
     public void setAuthor(String author)
     {
          this.author = author;
     }
     public String getAuthor()
     {
          return author;
     }
     public void setId(String id)
     {
          this.id = id;
     }
     public String getId()
     {
          return id;
     }
     public void setAvailable(boolean available)
     {
          this.available = available;
     }
     public boolean isAvailable()
     {
          return available;
     }
     public void setCategory(String category)
     {
          this.category = category;
     }
     public String getCategory()
     {
          return category;
     }
     public String toString()
     {
          return "Book is " + getTitle() + " by author " + getAuthor() + " having library Id " +  getId() +
                    " of category " + getCategory() + " . Book is available: " + isAvailable();
     }
}
