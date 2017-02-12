package com.candela.bookingpad.hotelops.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hb/hotel")
public class HotelHeartBeatController {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HotelHeartBeatController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getSingleUser() {
        LOGGER.info("#########INFO####################Heart beat detected from hotelops##########################################");
        return "Heart beat detected from hotelops";
    }
}
