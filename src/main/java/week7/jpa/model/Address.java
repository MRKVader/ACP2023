package week7.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address extends EntityId {

    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String appNum;

    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)
    private List<Author> authorList;

    public Address() {
    }

    public Address(String city, String street, String appNum) {
        this.city = city;
        this.street = street;
        this.appNum = appNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", appNum='" + appNum + '\'' +
                '}';
    }
}
