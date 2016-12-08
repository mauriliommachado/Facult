/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author mauri
 */
@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private MessageType type;
    @NotBlank
    private String message;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalTime release;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalTime expire;
    @ManyToOne
    private Event event;
    @ManyToOne
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

    public Person getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }
}
