
package com.iqmsoft.payara.hibernate;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findOne", query = "select p from Customer p where p.id = :id"),
        @NamedQuery(name = "Customer.getAll", query = "select p from Customer p")
    }
)
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String lastName;

    public Customer() {
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
