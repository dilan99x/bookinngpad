package com.candela.bookingpad.activityops.service;

import com.candela.bookingpad.dto.ActivityOrganizationDto;
import com.candela.bookingpad.entity.Activity;
import com.candela.bookingpad.entity.ActivityOrganization;

import java.util.List;

public interface ActivityManager {
    Activity addActivity(final Activity activity);

    Activity updateActivity(final Activity activity);

    //todo pagination need to add below
    List<Activity> findActivities();

    ActivityOrganization assignActivityToOrganization(Long activityId, Long organizationId);
}
