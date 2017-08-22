
package com.iqmsoft.payara.hibernate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAll() {
        return entityManager.createNamedQuery("Customer.getAll", Customer.class).getResultList();
    }

    public Customer find(Long id) {
        return entityManager.createNamedQuery("Customer.findOne", Customer.class).setParameter("id", id).getSingleResult();
    }

    public void save(Customer person) {
        entityManager.persist(person);
    }

    public void update(Customer person) {
        entityManager.merge(person);
    }

    public void delete(Customer person) {
        entityManager.remove(person);
    }
}