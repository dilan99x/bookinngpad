package com.candela.bookingpad.activityops.service.impl;


import com.candela.bookingpad.activityops.custom.ActivityOrganizationRepository;
import com.candela.bookingpad.activityops.custom.ActivityRepository;
import com.candela.bookingpad.activityops.custom.OrganizationRepository;
import com.candela.bookingpad.activityops.service.ActivityManager;
import com.candela.bookingpad.entity.Activity;
import com.candela.bookingpad.entity.ActivityOrganization;
import com.candela.bookingpad.entity.Organization;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityManagerImpl implements ActivityManager {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ActivityManagerImpl.class);

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityOrganizationRepository activityOrganizationRepository;

    @Override
    public Activity addActivity(final Activity activity) {
        LOGGER.info("Adding activity");
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(final Activity activity) {
        LOGGER.info("Updating activity");
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findActivities() {
        LOGGER.info("Listing all activities");
        return activityRepository.findAll();
    }

    @Override
    public ActivityOrganization assignActivityToOrganization(Long activityId, Long organizationId) {
        Organization organization = organizationRepository.findOne(organizationId);
        Activity activity = activityRepository.findOne(activityId);
        if (activity != null && organization != null) {
            ActivityOrganization activityOrganization = new ActivityOrganization();
            activityOrganization.setActivity(activity);
            activityOrganization.setOrganization(organization);
            return activityOrganizationRepository.save(activityOrganization);
        }

        throw new IllegalArgumentException("Activity Id and Organizatin Id cannot be null");
    }
}
