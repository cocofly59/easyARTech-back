// This is a test
package eart.back.end.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    public int id;

    public String name;

}
