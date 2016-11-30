/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Person;
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
public class PersonDAO implements DAO<Person> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Person entity) {
        manager.persist(entity);
    }

    @Override
    public List<Person> list() {
        return manager.createQuery("select distinct(p) from Person p ", Person.class).getResultList();
    }

    @Override
    public Person find(Integer id) {
        TypedQuery<Person> query = manager
                .createQuery(
                        "select distinct(p) from Person p where p.id=:id",
                        Person.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
