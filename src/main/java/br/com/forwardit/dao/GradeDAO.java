/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Grade;
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
public class GradeDAO implements DAO<Grade> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Grade entity) {
        manager.persist(entity);
    }
    
    
    public void remove(Integer id) {
        manager.remove(find(id));
    }

    @Override
    public List<Grade> list() {
        return manager.createQuery("select distinct(g) from Grade g ", Grade.class).getResultList();
    }

    @Override
    public Grade find(Integer id) {
        TypedQuery<Grade> query = manager
                .createQuery(
                        "select distinct(g) from Grade g where g.id=:id",
                        Grade.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
