/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Schedule;
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
public class ScheduleDAO implements DAO<Schedule> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Schedule entity) {
        manager.persist(entity);
    }

    @Override
    public List<Schedule> list() {
        return manager.createQuery("select distinct(s) from Schedule s ", Schedule.class).getResultList();
    }

    @Override
    public Schedule find(Integer id) {
        TypedQuery<Schedule> query = manager
                .createQuery("select distinct(s) from Schedule s where s.id=:id",
                        Schedule.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
