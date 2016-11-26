/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.facult.models.dao;

import br.com.forwardit.facult.models.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maurilio
 */
public class JPAPersonDAO implements DAO<Person> {

    private List<Person> lista = new ArrayList<>();

    public JPAPersonDAO() {
        Person p = new Person();
        p.setName("Maurílio");
        lista.add(p);
    }

    @Override
    public int gravar(Person entidade) {
        entidade.setId(lista.size()+1);
        lista.add(entidade);
        return entidade.getId();
    }

    @Override
    public List<Person> listarTodos() {
        return lista;
    }

    @Override
    public Person busca(int id) {
        return lista.stream().filter(p->p.getId()==id).findFirst().get();
    }

    @Override
    public void excluir(Person entidade) {
        lista.removeIf(p-> p.getId()==entidade.getId());
    }

    @Override
    public List<Person> findByNamedQuery(String namedQuery, Map<String, Object> namedParams, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
