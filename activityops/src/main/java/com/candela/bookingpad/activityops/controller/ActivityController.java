package com.candela.bookingpad.activityops.controller;

import com.candela.bookingpad.activityops.mapper.ActivityOrganizationMapper;
import com.candela.bookingpad.activityops.service.ActivityManager;
import com.candela.bookingpad.dto.ActivityOrganizationDto;
import com.candela.bookingpad.entity.Activity;
import com.candela.bookingpad.entity.ActivityOrganization;
import com.candela.bookingpad.exception.APIException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);
    @Autowired
    private ActivityManager activityManager;
    @Autowired
    private ActivityOrganizationMapper activityOrganizationMapper;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_JSON})
    @ResponseBody
    public Activity addActivity(@RequestBody Activity activity) {
        LOGGER.info("Calling ActivityController->addActivity method");
        return activityManager.addActivity(activity);
    }

    @RequestMapping(value = "/{activityId}/assign/organization/{organizationId}", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON})
    public ActivityOrganizationDto assignActivityOrganization(@PathVariable Long activityId, @PathVariable Long organizationId) throws APIException {
        LOGGER.info("Calling ActivityController->assignActivityOrganization method (" + activityId + " " + organizationId);
        ActivityOrganizationDto activityOrganizationDto = activityOrganizationMapper
                .mapToDto(activityManager.assignActivityToOrganization(activityId, organizationId),
                        new ActivityOrganizationDto());
        return activityOrganizationDto;
    }
}
