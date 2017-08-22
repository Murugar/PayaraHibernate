
package com.iqmsoft.payara.hibernate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;


@Stateless
@Path("customer")
public class CustomerResource {

    @Inject
    private CustomerDao customerDao;

    @GET
    @Produces("application/json")
    public List<Customer> all() {
        return customerDao.getAll();
    }

    @POST
    @Consumes("application/json")
    public void save(Customer person) {
        customerDao.save(person);
    }

    @PUT
    @Consumes("application/json")
    public void update(Customer person) {
        customerDao.update(person);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") Long id) {
        Customer person = customerDao.find(id);
        customerDao.delete(person);
    }
}
