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
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Message.findById", query = "SELECT m FROM Messages m WHERE m.id = :id"),
    @NamedQuery(name = "Message.findByText", query = "SELECT m FROM Messages m WHERE m.text = :text"),
    @NamedQuery(name = "Message.findByScheduleId", query = "SELECT m FROM Messages m WHERE m.scheduleId = :scheduleId")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "schedule_id")
    private int scheduleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private MessageType type;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageId")
    private List<MessagesPerson> messagesPersonList;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Messages(Integer id, String text, int scheduleId) {
        this.id = id;
        this.text = text;
        this.scheduleId = scheduleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @XmlTransient
    public List<MessagesPerson> getMessagesPersonList() {
        return messagesPersonList;
    }

    public void setMessagesPersonList(List<MessagesPerson> messagesPersonList) {
        this.messagesPersonList = messagesPersonList;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.forwardit.model.Message[ id=" + id + " ]";
    }
    
}
