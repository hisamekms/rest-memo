/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.domain.user;

import com.cc.infra.entity.PersistentEntity;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ooyamashinnosuke
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByCreatedId", query = "SELECT u FROM User u WHERE u.createdId = :createdId"),
    @NamedQuery(name = "User.findByCreatedTimestamp", query = "SELECT u FROM User u WHERE u.createdTimestamp = :createdTimestamp"),
    @NamedQuery(name = "User.findByLastModifiedId", query = "SELECT u FROM User u WHERE u.lastModifiedId = :lastModifiedId"),
    @NamedQuery(name = "User.findByLastModifiedTimestamp", query = "SELECT u FROM User u WHERE u.lastModifiedTimestamp = :lastModifiedTimestamp")})
public class User extends PersistentEntity<String> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID", nullable = false, length = 20)
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CREATED_ID", nullable = false, length = 20)
    private String createdId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimestamp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LAST_MODIFIED_ID", nullable = false, length = 20)
    private String lastModifiedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_MODIFIED_TIMESTAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTimestamp;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getLastModifiedId() {
        return lastModifiedId;
    }

    public void setLastModifiedId(String lastModifiedId) {
        this.lastModifiedId = lastModifiedId;
    }

    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Date lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isNew() {
        return createdId == null;
    }
    
}
