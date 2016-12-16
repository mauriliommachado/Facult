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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "attendantgroup_person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendantgroupPerson.findAll", query = "SELECT a FROM AttendantgroupPerson a"),
    @NamedQuery(name = "AttendantgroupPerson.findById", query = "SELECT a FROM AttendantgroupPerson a WHERE a.id = :id")})
public class AttendantgroupPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "attendantgroup_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Attendantgroup attendantgroupId;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;

    public AttendantgroupPerson() {
    }

    public AttendantgroupPerson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attendantgroup getAttendantgroupId() {
        return attendantgroupId;
    }

    public void setAttendantgroupId(Attendantgroup attendantgroupId) {
        this.attendantgroupId = attendantgroupId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendantgroupPerson)) {
            return false;
        }
        AttendantgroupPerson other = (AttendantgroupPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.AttendantgroupPerson[ id=" + id + " ]";
    }
    
}
