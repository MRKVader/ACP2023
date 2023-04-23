package week7.jpa.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Book extends EntityId {

    @Column(nullable = false)
    private String titleBook;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @Column(length = 20)
    private String city;

    @Temporal(TemporalType.DATE)
    private Date printDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "authors_books",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Author> authorList;

    private double price;

    public Book() {
    }

    public Book(String titleBook, BookType bookType, String city, Date printDate, double price) {
        this.titleBook = titleBook;
        this.bookType = bookType;
        this.city = city;
        this.printDate = printDate;
        this.price = price;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", titleBook='" + titleBook + '\'' +
                ", bookType=" + bookType +
                ", city='" + city + '\'' +
                ", printDate=" + printDate +
                ", price=" + price +
                '}';
    }

    public enum BookType {
        IT, NOVEL, FANTASY;
    }
}
