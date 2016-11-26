/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.facult.models;

import java.util.List;
import org.joda.time.LocalTime;

/**
 *
 * @author mauri
 */
public class Messages {
    private Integer id;
    private MessageType type;
    private String message;
    private List<Person> persons;
    private LocalTime release;
    private LocalTime expire;
    private Event event;
    private Person personFrom;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalTime getRelease() {
        return release;
    }

    public void setRelease(LocalTime release) {
        this.release = release;
    }

    public LocalTime getExpire() {
        return expire;
    }

    public void setExpire(LocalTime expire) {
        this.expire = expire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }
}
