/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.dao;

import java.util.List;

/**
 *
 * @author mauri
 */
public interface DAO<E> {
    public void save(E entity);

    public void remove(Integer id);
    
    public List<E> list();

    public E find(Integer id);
}
