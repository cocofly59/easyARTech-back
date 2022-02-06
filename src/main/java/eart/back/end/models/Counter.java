// This is a test
package eart.back.end.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Counter {

    @Id
    public String name;

    public int value;
}
