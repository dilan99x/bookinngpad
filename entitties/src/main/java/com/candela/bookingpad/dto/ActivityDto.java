package com.candela.bookingpad.dto;
import com.candela.bookingpad.entity.*;

import java.util.Date;
import java.util.List;

public class ActivityDto {
    private Long activityId;
    private String activityCode;
    private String activityDescription;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private Date addedDate;
    private Date updatedDate;
    private Boolean isAvailable;
    private List<Integer> locationList;
    private ActivityProperty activityPropertyId;
    private ActivityType activityTypeId;
    private User addedBy;
    private User updatedBy;
    private List<Integer> activityOrganizationList;

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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<Integer> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Integer> locationList) {
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

    public List<Integer> getActivityOrganizationList() {
        return activityOrganizationList;
    }

    public void setActivityOrganizationList(List<Integer> activityOrganizationList) {
        this.activityOrganizationList = activityOrganizationList;
    }
}
