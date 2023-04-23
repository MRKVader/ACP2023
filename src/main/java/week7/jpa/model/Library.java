package week7.jpa.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library_shop")
@NamedQueries({@NamedQuery(name = "getAll", query = "SELECT ls FROM Library ls")})
public class Library extends EntityId {

    @Column(nullable = false)
    private String shopName;
    private String discription;

    private Author owner;

    private Set<Book> bookSet;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Author getOwner() {
        return owner;
    }

    public void setOwner(Author owner) {
        this.owner = owner;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public String toString() {
        return "Library{" +
                "shopName='" + shopName + '\'' +
                ", discription='" + discription + '\'' +
                ", owner=" + owner +
                ", bookSet=" + bookSet +
                '}';
    }
}
