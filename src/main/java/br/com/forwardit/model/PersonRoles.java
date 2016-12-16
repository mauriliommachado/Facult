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
@Table(name = "person_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonRoles.findAll", query = "SELECT p FROM PersonRoles p"),
    @NamedQuery(name = "PersonRoles.findById", query = "SELECT p FROM PersonRoles p WHERE p.id = :id")})
public class PersonRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "roles_name", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Roles rolesName;

    public PersonRoles() {
    }

    public PersonRoles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Roles getRolesName() {
        return rolesName;
    }

    public void setRolesName(Roles rolesName) {
        this.rolesName = rolesName;
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
        if (!(object instanceof PersonRoles)) {
            return false;
        }
        PersonRoles other = (PersonRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.PersonRoles[ id=" + id + " ]";
    }
    
}
