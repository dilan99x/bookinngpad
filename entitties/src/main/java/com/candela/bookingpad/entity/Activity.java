package com.candela.bookingpad.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activity")
@XmlRootElement
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_id")
    private Long activityId;
    @Column(name = "activity_code")
    private String activityCode;
    @Column(name = "activity_description")
    private String activityDescription;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @JoinTable(name = "activity_location", joinColumns = {
            @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")}, inverseJoinColumns = {
            @JoinColumn(name = "location_id", referencedColumnName = "location_id")})
    @ManyToMany
    private List<Location> locationList;
    @JoinColumn(name = "activity_property_id", referencedColumnName = "activity_property_id")
    @ManyToOne
    private ActivityProperty activityPropertyId;
    @JoinColumn(name = "activity_type_id", referencedColumnName = "activity_type_id")
    @ManyToOne
    private ActivityType activityTypeId;
    @JoinColumn(name = "added_by", referencedColumnName = "user_id")
    @ManyToOne
    private User addedBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @ManyToOne
    private User updatedBy;
    @OneToMany(mappedBy = "activity")
    private List<ActivityOrganization> activityOrganizationList;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public ActivityProperty getActivityPropertyId() {
        return activityPropertyId;
    }

    public void setActivityPropertyId(ActivityProperty activityPropertyId) {
        this.activityPropertyId = activityPropertyId;
    }

    public ActivityType getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(ActivityType activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
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
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Activity[ activityId=" + activityId + " ]";
    }
}
