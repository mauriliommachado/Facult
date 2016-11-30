/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.State;
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
public class StateDAO implements DAO<State> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(State entity) {
        manager.persist(entity);
    }

    @Override
    public List<State> list() {
        return manager.createQuery("select distinct(s) from State s ", State.class).getResultList();
    }

    @Override
    public State find(Integer id) {
        TypedQuery<State> query = manager
                .createQuery("select distinct(s) from State s where s.id=:id",
                        State.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
