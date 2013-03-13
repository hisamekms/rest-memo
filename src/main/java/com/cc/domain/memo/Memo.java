/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.domain.memo;

import com.cc.infra.entity.PersistentEntity;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "MEMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memo.findAll", query = "SELECT m FROM Memo m"),
    @NamedQuery(name = "Memo.findById", query = "SELECT m FROM Memo m WHERE m.id = :id"),
    @NamedQuery(name = "Memo.findByUserId", query = "SELECT m FROM Memo m WHERE m.userId = :userId"),
    @NamedQuery(name = "Memo.findByMemo", query = "SELECT m FROM Memo m WHERE m.memo = :memo"),
    @NamedQuery(name = "Memo.findByCreatedId", query = "SELECT m FROM Memo m WHERE m.createdId = :createdId"),
    @NamedQuery(name = "Memo.findByCreatedTimestamp", query = "SELECT m FROM Memo m WHERE m.createdTimestamp = :createdTimestamp"),
    @NamedQuery(name = "Memo.findByLastModifiedId", query = "SELECT m FROM Memo m WHERE m.lastModifiedId = :lastModifiedId"),
    @NamedQuery(name = "Memo.findByLastModifiedTimestamp", query = "SELECT m FROM Memo m WHERE m.lastModifiedTimestamp = :lastModifiedTimestamp")})
public class Memo extends PersistentEntity<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USER_ID", nullable = false, length = 20)
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "MEMO", nullable = false, length = 2000)
    private String memo;
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
    
}
