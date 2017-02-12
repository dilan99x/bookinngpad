package com.candela.bookingpad.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by thilanka on 2/20/16.
 */
public class ActivityOrganizationDto {

    private Long activityOrganizationId;
    private Boolean isActive;
    private List<Integer> offerList;
    private Long activity;
    private Long organization;
    private List<Integer> paymentList;

    public Long getActivityOrganizationId() {
        return activityOrganizationId;
    }

    public void setActivityOrganizationId(Long activityOrganizationId) {
        this.activityOrganizationId = activityOrganizationId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Integer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Integer> offerList) {
        this.offerList = offerList;
    }

    public Long getActivity() {
        return activity;
    }

    public void setActivity(Long activity) {
        this.activity = activity;
    }

    public Long getOrganization() {
        return organization;
    }

    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    public List<Integer> getPaymentList() {
        return paymentList == null ? new LinkedList<>() : paymentList;
    }

    public void setPaymentList(List<Integer> paymentList) {
        this.paymentList = paymentList == null ? new LinkedList<>() : paymentList;
    }
}
