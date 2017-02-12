package com.candela.bookingpad.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "location")
@XmlRootElement
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "location_code")
    private String locationCode;
    @Column(name = "district")
    private String district;
    @Column(name = "province")
    private String province;
    @ManyToMany(mappedBy = "locationList")
    private List<Activity> activityList;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
        return new HashCodeBuilder().append(locationCode).append(district).append(province).toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;

        new EqualsBuilder().append(this.locationCode, other.locationCode).
                append(this.district, other.district).append(this.province, other.province).isEquals();
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[ locationId=" + locationId + " ]";
    }
}
