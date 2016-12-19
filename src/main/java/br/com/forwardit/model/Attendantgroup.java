/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "attendantgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendantgroup.findAll", query = "SELECT a FROM Attendantgroup a"),
    @NamedQuery(name = "Attendantgroup.findById", query = "SELECT a FROM Attendantgroup a WHERE a.id = :id"),
    @NamedQuery(name = "Attendantgroup.findByDescription", query = "SELECT a FROM Attendantgroup a WHERE a.description = :description")})
public class Attendantgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attendantgroupId")
    private List<AttendantgroupPerson> attendantgroupPersonList;

    public Attendantgroup() {
    }

    public Attendantgroup(Integer id) {
        this.id = id;
    }

    public Attendantgroup(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<AttendantgroupPerson> getAttendantgroupPersonList() {
        return attendantgroupPersonList;
    }

    public void setAttendantgroupPersonList(List<AttendantgroupPerson> attendantgroupPersonList) {
        this.attendantgroupPersonList = attendantgroupPersonList;
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
        if (!(object instanceof Attendantgroup)) {
            return false;
        }
        Attendantgroup other = (Attendantgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Attendantgroup[ id=" + id + " ]";
    }
    
}
