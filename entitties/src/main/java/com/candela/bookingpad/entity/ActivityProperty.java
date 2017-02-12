package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "activity_property")
@XmlRootElement
public class ActivityProperty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_property_id")
    private Integer activityPropertyId;
    @Column(name = "property_code")
    private String propertyCode;
    @Column(name = "is_valid")
    private Boolean isValid;
    @Column(name = "property_description")
    private String propertyDescription;
    @OneToMany(mappedBy = "activityPropertyId")
    private List<Activity> activityList;


    public Integer getActivityPropertyId() {
        return activityPropertyId;
    }

    public void setActivityPropertyId(Integer activityPropertyId) {
        this.activityPropertyId = activityPropertyId;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
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
        hash += (activityPropertyId != null ? activityPropertyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityProperty)) {
            return false;
        }
        ActivityProperty other = (ActivityProperty) object;
        if ((this.activityPropertyId == null && other.activityPropertyId != null) || (this.activityPropertyId != null && !this.activityPropertyId.equals(other.activityPropertyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivityProperty[ activityPropertyId=" + activityPropertyId + " ]";
    }

}
