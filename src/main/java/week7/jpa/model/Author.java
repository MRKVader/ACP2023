package week7.jpa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends EntityId { //class -> table? hibernate!!!

    @Column(name = "a_name", length = 20, nullable = false) //parameters column
    private String aName;
    @Column
    private double salary;
    @Column
    @Temporal(TemporalType.DATE) //type of data
    private Date birthDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToMany
    private List<Book> bookList;

    public Author(String aName, double salary, Date birthDate) {
        this.aName = aName;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                ", aName='" + aName + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
