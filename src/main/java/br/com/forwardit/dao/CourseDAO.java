/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Course;
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
public class CourseDAO implements DAO<Course> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Course entity) {
        manager.persist(entity);
    }

    @Override
    public List<Course> list() {
        return manager.createQuery("select distinct(c) from Course c ", Course.class).getResultList();
    }

    @Override
    public Course find(Integer id) {
        TypedQuery<Course> query = manager
                .createQuery(
                        "select distinct(c) from Course c where c.id=:id",
                        Course.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
