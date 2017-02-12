package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "organization_type")
@XmlRootElement
public class OrganizationType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "organization_type_id")
    private Integer organizationTypeId;
    @Column(name = "organization_type_code")
    private String organizationTypeCode;
    @Column(name = "organization_description")
    private String organizationDescription;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(mappedBy = "organizationTypeId")
    private List<Organization> organizationList;

    public Integer getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(Integer organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    public String getOrganizationTypeCode() {
        return organizationTypeCode;
    }

    public void setOrganizationTypeCode(String organizationTypeCode) {
        this.organizationTypeCode = organizationTypeCode;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationTypeId != null ? organizationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizationType)) {
            return false;
        }
        OrganizationType other = (OrganizationType) object;
        if ((this.organizationTypeId == null && other.organizationTypeId != null) || (this.organizationTypeId != null && !this.organizationTypeId.equals(other.organizationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrganizationType[ organizationTypeId=" + organizationTypeId + " ]";
    }
}
