/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Evaluation;
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
public class EvaluationDAO implements DAO<Evaluation> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Evaluation entity) {
        manager.persist(entity);
    }

    @Override
    public List<Evaluation> list() {
        return manager.createQuery("select distinct(e) from Evaluation e ", Evaluation.class).getResultList();
    }

    @Override
    public Evaluation find(Integer id) {
        TypedQuery<Evaluation> query = manager
                .createQuery(
                        "select distinct(c) from Evaluation e where e.id=:id",
                        Evaluation.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
