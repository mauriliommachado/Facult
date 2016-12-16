/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Attendantgroup;
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
public class AttendantGroupDAO implements DAO<Attendantgroup>{
    @PersistenceContext
    private EntityManager manager;

    public void save(Attendantgroup attendantGroup) {
        manager.persist(attendantGroup);
    }

    public List<Attendantgroup> list() {
        return manager.createQuery("select distinct(ag) from Attendantgroup ag ", Attendantgroup.class).getResultList();
    }

    public Attendantgroup find(Integer id) {
        TypedQuery<Attendantgroup> query = manager
                .createQuery(
                        "select distinct(ag) from Attendantgroup ag where ag.id=:id",
                        Attendantgroup.class).setParameter("id", id);
        return query.getSingleResult();
    }    

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
