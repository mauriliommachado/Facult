/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Contact;
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
public class ContactDAO implements DAO<Contact> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Contact entity) {
        manager.persist(entity);
    }

    @Override
    public List<Contact> list() {
        return manager.createQuery("select distinct(c) from Contact c ", Contact.class).getResultList();
    }

    @Override
    public Contact find(Integer id) {
        TypedQuery<Contact> query = manager
                .createQuery(
                        "select distinct(c) from Contact c where c.id=:id",
                        Contact.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
