package com.candela.bookingpad.dto;

import java.util.List;

public class OrganizationDto {

    private Long organizationId;
    private String organizationName;
    private String organizationAddress;
    private String description;
    private Boolean isActive;
    private Long organizationTypeId;
    private List<Long> activityOrganizationList;
    private List<Long> activityList;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(Long organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
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

    public List<Long> getActivityOrganizationList() {
        return activityOrganizationList;
    }

    public void setActivityOrganizationList(List<Long> activityOrganizationList) {
        this.activityOrganizationList = activityOrganizationList;
    }

    public List<Long> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Long> activityList) {
        this.activityList = activityList;
    }
}
