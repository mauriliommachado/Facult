/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.util.List;

/**
 *
 * @author mauri
 */
public class Contact {
    private Integer id;
    private Person person;
    private ContactType type;
    private String value;
    private List<Person> wardedPersons;

    public List<Person> getWardedPersons() {
        return wardedPersons;
    }

    public void setWardedPersons(List<Person> wardedPersons) {
        this.wardedPersons = wardedPersons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    private String notes;
}
