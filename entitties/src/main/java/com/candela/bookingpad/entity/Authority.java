package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authority")
@XmlRootElement
public class Authority implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authority_id")
    private Integer authorityId;
    @Basic(optional = false)
    @Column(name = "authority_name")
    private String authorityName;
    @ManyToMany(mappedBy = "authorityList")
    private List<User> userList;

    public Authority(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Authority(Integer authorityId, String authorityName) {
        this.authorityId = authorityId;
        this.authorityName = authorityName;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorityId != null ? authorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.authorityId == null && other.authorityId != null) || (this.authorityId != null && !this.authorityId.equals(other.authorityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Authority[ authorityId=" + authorityId + " ]";
    }
}
