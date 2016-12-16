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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByFrequency", query = "SELECT s FROM Schedule s WHERE s.frequency = :frequency")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "createDate")
    private byte[] createDate;
    @Lob
    @Column(name = "endDate")
    private byte[] endDate;
    @Lob
    @Column(name = "expire")
    private byte[] expire;
    @Column(name = "frequency")
    private Integer frequency;
    @Lob
    @Column(name = "startDate")
    private byte[] startDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private List<Event> eventList;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getCreateDate() {
        return createDate;
    }

    public void setCreateDate(byte[] createDate) {
        this.createDate = createDate;
    }

    public byte[] getEndDate() {
        return endDate;
    }

    public void setEndDate(byte[] endDate) {
        this.endDate = endDate;
    }

    public byte[] getExpire() {
        return expire;
    }

    public void setExpire(byte[] expire) {
        this.expire = expire;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public byte[] getStartDate() {
        return startDate;
    }

    public void setStartDate(byte[] startDate) {
        this.startDate = startDate;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Schedule[ id=" + id + " ]";
    }
    
}
