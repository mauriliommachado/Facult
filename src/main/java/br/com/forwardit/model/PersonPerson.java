/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "person_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonPerson.findAll", query = "SELECT p FROM PersonPerson p"),
    @NamedQuery(name = "PersonPerson.findByInt1", query = "SELECT p FROM PersonPerson p WHERE p.int1 = :int1")})
public class PersonPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "int")
    private Integer int1;
    @JoinColumn(name = "guardian_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person guardianId;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;

    public PersonPerson() {
    }

    public PersonPerson(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Person getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Person guardianId) {
        this.guardianId = guardianId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int1 != null ? int1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPerson)) {
            return false;
        }
        PersonPerson other = (PersonPerson) object;
        if ((this.int1 == null && other.int1 != null) || (this.int1 != null && !this.int1.equals(other.int1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.PersonPerson[ int1=" + int1 + " ]";
    }
    
}
