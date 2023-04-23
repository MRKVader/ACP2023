package week7.jpa.model;

import javax.persistence.*;

@MappedSuperclass
public class EntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId entityId)) return false;

        return id == entityId.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
