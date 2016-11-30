/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Messages;
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
public class MessagesDAO implements DAO<Messages> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Messages entity) {
        manager.persist(entity);
    }

    @Override
    public List<Messages> list() {
        return manager.createQuery("select distinct(m) from Messages m ", Messages.class).getResultList();
    }

    @Override
    public Messages find(Integer id) {
        TypedQuery<Messages> query = manager
                .createQuery(
                        "select distinct(m) from Messages m where m.id=:id",
                        Messages.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
