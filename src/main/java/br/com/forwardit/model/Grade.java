/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findById", query = "SELECT g FROM Grade g WHERE g.id = :id"),
    @NamedQuery(name = "Grade.findByGrade", query = "SELECT g FROM Grade g WHERE g.grade = :grade")})
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private double grade;
    @OneToMany(mappedBy = "midTermGradeid")
    private List<Discipline> disciplineList;
    @OneToMany(mappedBy = "failGradeid")
    private List<Discipline> disciplineList1;
    @OneToMany(mappedBy = "successGradeid")
    private List<Discipline> disciplineList2;
    @OneToMany(mappedBy = "gradeId")
    private List<Evaluation> evaluationList;

    public Grade() {
    }

    public Grade(Integer id) {
        this.id = id;
    }

    public Grade(Integer id, double grade) {
        this.id = id;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList1() {
        return disciplineList1;
    }

    public void setDisciplineList1(List<Discipline> disciplineList1) {
        this.disciplineList1 = disciplineList1;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList2() {
        return disciplineList2;
    }

    public void setDisciplineList2(List<Discipline> disciplineList2) {
        this.disciplineList2 = disciplineList2;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
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
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Grade[ id=" + id + " ]";
    }
    
}
