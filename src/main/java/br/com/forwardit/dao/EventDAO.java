/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Event;
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
public class EventDAO implements DAO<Event> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Event entity) {
        manager.persist(entity);
    }

    @Override
    public List<Event> list() {
        return manager.createQuery("select distinct(e) from Event e ", Event.class).getResultList();
    }

    @Override
    public Event find(Integer id) {
        TypedQuery<Event> query = manager
                .createQuery(
                        "select distinct(c) from Event e where e.id=:id",
                        Event.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
