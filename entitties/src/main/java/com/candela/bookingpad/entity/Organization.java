package com.candela.bookingpad.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "organization")
@XmlRootElement
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "organization_id")
    private Long organizationId;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "organization_address")
    private String organizationAddress;
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private Boolean isActive;
    @JoinColumn(name = "organization_type_id", referencedColumnName = "organization_type_id")
    @ManyToOne
    private OrganizationType organizationTypeId;
    @OneToMany(mappedBy = "organization")
    private List<ActivityOrganization> activityOrganizationList;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OrganizationType getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(OrganizationType organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    @XmlTransient
    public List<ActivityOrganization> getActivityOrganizationList() {
        return activityOrganizationList;
    }

    public void setActivityOrganizationList(List<ActivityOrganization> activityOrganizationList) {
        this.activityOrganizationList = activityOrganizationList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.organizationName).append(this.organizationAddress).toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) object;

        return new EqualsBuilder().append(this.getOrganizationName(), organization.getOrganizationName()).
                append(this.getOrganizationAddress(), organization.getOrganizationAddress()).isEquals();
    }

    @Override
    public String toString() {
        return "entity.Organization[ organizationId=" + organizationId + " ]";
    }
}
