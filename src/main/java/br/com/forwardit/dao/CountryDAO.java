/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import br.com.forwardit.model.Country;
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
public class CountryDAO implements DAO<Country> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Country entity) {
        manager.persist(entity);
    }

    @Override
    public List<Country> list() {
        return manager.createQuery("select distinct(c) from Country c ", Country.class).getResultList();
    }

    @Override
    public Country find(Integer id) {
        TypedQuery<Country> query = manager
                .createQuery(
                        "select distinct(c) from Country c where c.id=:id",
                        Country.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        manager.remove(find(id));
    }
}
