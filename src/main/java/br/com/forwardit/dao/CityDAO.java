/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.City;
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
public class CityDAO implements DAO<City> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(City entity) {
        manager.persist(entity);
    }

    @Override
    public List<City> list() {
        return manager.createQuery("select distinct(c) from City c ", City.class).getResultList();
    }

    @Override
    public City find(Integer id) {
        TypedQuery<City> query = manager
                .createQuery(
                        "select distinct(c) from City c where c.id=:id",
                        City.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
