/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mauri
 */
@Repository
public class PersonDAO implements DAO<Person>, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TypedQuery<Person> query = manager
                .createQuery(
                        "select distinct(p) from Person p where p.record=:record",
                        Person.class).setParameter("record", userName);
        Person p;
        try{
            p = query.getSingleResult();
        }catch(NoResultException nre){
            throw new UsernameNotFoundException("O usuário "+userName+" não existe");
        }
        return p;
    }
}
