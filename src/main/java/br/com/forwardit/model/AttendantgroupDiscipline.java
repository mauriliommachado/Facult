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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "attendantgroup_discipline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendantgroupDiscipline.findAll", query = "SELECT a FROM AttendantgroupDiscipline a"),
    @NamedQuery(name = "AttendantgroupDiscipline.findById", query = "SELECT a FROM AttendantgroupDiscipline a WHERE a.id = :id"),
    @NamedQuery(name = "AttendantgroupDiscipline.findByAttendantgroupId", query = "SELECT a FROM AttendantgroupDiscipline a WHERE a.attendantgroupId = :attendantgroupId"),
    @NamedQuery(name = "AttendantgroupDiscipline.findByDisciplineId", query = "SELECT a FROM AttendantgroupDiscipline a WHERE a.disciplineId = :disciplineId")})
public class AttendantgroupDiscipline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attendantgroup_id")
    private int attendantgroupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discipline_id")
    private int disciplineId;

    public AttendantgroupDiscipline() {
    }

    public AttendantgroupDiscipline(Integer id) {
        this.id = id;
    }

    public AttendantgroupDiscipline(Integer id, int attendantgroupId, int disciplineId) {
        this.id = id;
        this.attendantgroupId = attendantgroupId;
        this.disciplineId = disciplineId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAttendantgroupId() {
        return attendantgroupId;
    }

    public void setAttendantgroupId(int attendantgroupId) {
        this.attendantgroupId = attendantgroupId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
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
        if (!(object instanceof AttendantgroupDiscipline)) {
            return false;
        }
        AttendantgroupDiscipline other = (AttendantgroupDiscipline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.AttendantgroupDiscipline[ id=" + id + " ]";
    }
    
}
