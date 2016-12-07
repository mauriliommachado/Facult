/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Address;
import br.com.forwardit.model.AttendantGroup;
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
public class AttendantGroupDAO implements DAO<AttendantGroup>{
    @PersistenceContext
    private EntityManager manager;

    public void save(AttendantGroup attendantGroup) {
        manager.persist(attendantGroup);
    }

    public List<AttendantGroup> list() {
        return manager.createQuery("select distinct(ag) from AttendantGroup ag ", AttendantGroup.class).getResultList();
    }

    public AttendantGroup find(Integer id) {
        TypedQuery<AttendantGroup> query = manager
                .createQuery(
                        "select distinct(ag) from AttendantGroup ag where ag.id=:id",
                        AttendantGroup.class).setParameter("id", id);
        return query.getSingleResult();
    }    

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
