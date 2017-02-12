package com.candela.bookingpad.activityops.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hb/activity")
public class ActivityHeartBeatController {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ActivityHeartBeatController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getSingleUser() {
        LOGGER.info("#########INFO####################Heart beat detected from activityops##########################################");
        return "Heart beat detected from activityops";
    }
}
