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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "discipline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discipline.findAll", query = "SELECT d FROM Discipline d"),
    @NamedQuery(name = "Discipline.findById", query = "SELECT d FROM Discipline d WHERE d.id = :id"),
    @NamedQuery(name = "Discipline.findByDescription", query = "SELECT d FROM Discipline d WHERE d.description = :description"),
    @NamedQuery(name = "Discipline.findByNumberOfEvaluations", query = "SELECT d FROM Discipline d WHERE d.numberOfEvaluations = :numberOfEvaluations"),
    @NamedQuery(name = "Discipline.findByTitle", query = "SELECT d FROM Discipline d WHERE d.title = :title")})
public class Discipline implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfEvaluations")
    private int numberOfEvaluations;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "minister_id", referencedColumnName = "id")
    @ManyToOne
    private Person ministerId;
    @JoinColumn(name = "midTermGrade_id", referencedColumnName = "id")
    @ManyToOne
    private Grade midTermGradeid;
    @JoinColumn(name = "failGrade_id", referencedColumnName = "id")
    @ManyToOne
    private Grade failGradeid;
    @JoinColumn(name = "successGrade_id", referencedColumnName = "id")
    @ManyToOne
    private Grade successGradeid;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplineId")
    private List<Event> eventList;

    public Discipline() {
    }

    public Discipline(Integer id) {
        this.id = id;
    }

    public Discipline(Integer id, String description, int numberOfEvaluations, String title) {
        this.id = id;
        this.description = description;
        this.numberOfEvaluations = numberOfEvaluations;
        this.title = title;
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

    public int getNumberOfEvaluations() {
        return numberOfEvaluations;
    }

    public void setNumberOfEvaluations(int numberOfEvaluations) {
        this.numberOfEvaluations = numberOfEvaluations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getMinisterId() {
        return ministerId;
    }

    public void setMinisterId(Person ministerId) {
        this.ministerId = ministerId;
    }

    public Grade getMidTermGradeid() {
        return midTermGradeid;
    }

    public void setMidTermGradeid(Grade midTermGradeid) {
        this.midTermGradeid = midTermGradeid;
    }

    public Grade getFailGradeid() {
        return failGradeid;
    }

    public void setFailGradeid(Grade failGradeid) {
        this.failGradeid = failGradeid;
    }

    public Grade getSuccessGradeid() {
        return successGradeid;
    }

    public void setSuccessGradeid(Grade successGradeid) {
        this.successGradeid = successGradeid;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof Discipline)) {
            return false;
        }
        Discipline other = (Discipline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Discipline[ id=" + id + " ]";
    }
    
}
