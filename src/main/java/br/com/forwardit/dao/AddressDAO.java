/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mauri
 */
@Repository
public class AddressDAO {
    @PersistenceContext
    private EntityManager manager;

    public void save(Address product) {
        manager.persist(product);
    }

    public List<Address> list() {
        return manager.createQuery("select distinct(p) from Address p ", Address.class).getResultList();
    }

    public Address find(Integer id) {
        TypedQuery<Address> query = manager
                .createQuery(
                        "select distinct(p) from Address p where p.id=:id",
                        Address.class).setParameter("id", id);
        return query.getSingleResult();
    }    
}
