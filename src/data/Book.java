package data;

/**
 * Created by Pawel on 17.05.2017.
 */
// klasa dziedziczy z klasy publikacje kilka rzeczy
public class Book extends Publication {
    // POLA do wpisania
    private String author;
    private int pages;
    private String isbn;

    // settery i gettery
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Konstruktory
    public Book(String title, String author, int year, int pages,
                String publisher, String isbn){
        super(year,title,publisher);
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);

    }

    public Book(Book book){
        this(book.getTitle(),book.getAuthor(),book.getYear(),
                book.getPages(),book.getPublisher(),
                book.getIsbn());

    }
    //wyswietlanie
    @Override
    public String toString() {
        StringBuilder print=new StringBuilder();
        print.append(getTitle());
        print.append("; ");
        print.append(getAuthor());
        print.append("; ");
        print.append(getYear());
        print.append("; ");
        print.append(getPages());
        print.append("; ");
        print.append(getPublisher());
        print.append("; ");
        print.append(getIsbn());
        return print.toString();
    }


    // sprawdzenie czy rowne sa sobie stringi, potzebne do fuknci equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (pages != book.pages) return false;
        if (!author.equals(book.author)) return false;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + pages;
        result = 31 * result + isbn.hashCode();
        return result;
    }
}




