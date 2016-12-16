/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByCpf", query = "SELECT p FROM Person p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Person.findByGuardian", query = "SELECT p FROM Person p WHERE p.guardian = :guardian"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByNotes", query = "SELECT p FROM Person p WHERE p.notes = :notes"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findByRecord", query = "SELECT p FROM Person p WHERE p.record = :record"),
    @NamedQuery(name = "Person.findByType", query = "SELECT p FROM Person p WHERE p.type = :type")})
public class Person implements Serializable, UserDetails {

    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "registerDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guardian")
    private boolean guardian;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "record")
    private String record;
    @Column(name = "type")
    private Integer type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guardianId")
    private List<PersonPerson> guardians;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private List<PersonPerson> warded;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private List<Address> addressList;
    @OneToMany(mappedBy = "ministerId")
    private List<Discipline> disciplineList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private MessagesPerson messagesPerson;
    @OneToMany(mappedBy = "personId")
    private List<Evaluation> evaluationList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private AttendantgroupPerson attendantgroupPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId",fetch = FetchType.EAGER)
    private List<PersonRoles> personRolesList;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String cpf, boolean guardian, String name, String notes, String password, String record) {
        this.id = id;
        this.cpf = cpf;
        this.guardian = guardian;
        this.name = name;
        this.notes = notes;
        this.password = password;
        this.record = record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean getGuardian() {
        return guardian;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        this.password = encode.encode(password);
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @XmlTransient
    public List<PersonPerson> getPersonPersonList() {
        return guardians;
    }

    public void setPersonPersonList(List<PersonPerson> personPersonList) {
        this.guardians = personPersonList;
    }

    @XmlTransient
    public List<PersonPerson> getPersonPersonList1() {
        return warded;
    }

    public void setPersonPersonList1(List<PersonPerson> personPersonList1) {
        this.warded = personPersonList1;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public MessagesPerson getMessagesPerson() {
        return messagesPerson;
    }

    public void setMessagesPerson(MessagesPerson messagesPerson) {
        this.messagesPerson = messagesPerson;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public AttendantgroupPerson getAttendantgroupPerson() {
        return attendantgroupPerson;
    }

    public void setAttendantgroupPerson(AttendantgroupPerson attendantgroupPerson) {
        this.attendantgroupPerson = attendantgroupPerson;
    }

    @XmlTransient
    public List<PersonRoles> getPersonRolesList() {
        return personRolesList;
    }

    public void setPersonRolesList(List<PersonRoles> personRolesList) {
        this.personRolesList = personRolesList;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Person[ id=" + id + " ]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List roles = new ArrayList();
        personRolesList.stream().forEach(e -> roles.add(e.getRolesName()));
        return roles;
    }

    @Override
    public String getUsername() {
        return getRecord();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

}
