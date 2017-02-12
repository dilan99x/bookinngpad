package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "activity_type")
@XmlRootElement
public class ActivityType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_type_id")
    private Integer activityTypeId;
    @Column(name = "activity_type_code")
    private String activityTypeCode;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "property_description")
    private String propertyDescription;
    @OneToMany(mappedBy = "activityTypeId")
    private List<Activity> activityList;

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeCode() {
        return activityTypeCode;
    }

    public void setActivityTypeCode(String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    @XmlTransient
    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityTypeId != null ? activityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityType)) {
            return false;
        }
        ActivityType other = (ActivityType) object;
        if ((this.activityTypeId == null && other.activityTypeId != null) || (this.activityTypeId != null && !this.activityTypeId.equals(other.activityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivityType[ activityTypeId=" + activityTypeId + " ]";
    }

}

