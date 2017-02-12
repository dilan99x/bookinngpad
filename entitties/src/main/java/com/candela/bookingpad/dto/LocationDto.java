package com.candela.bookingpad.dto;

import java.util.List;

public class LocationDto {

    private Long locationId;
    private String locationCode;
    private String district;
    private String province;
    private List<Long> activityList;

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

    public List<Long> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Long> activityList) {
        this.activityList = activityList;
    }
}
