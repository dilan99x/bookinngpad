package com.candela.bookingpad.service;

import com.candela.bookingpad.dto.ActivityListDto;
import com.candela.bookingpad.entity.Location;
import com.candela.bookingpad.exception.APIException;

import java.util.List;

public interface LocationManager {

    Location findByLocationCode(String locationCode);

    Location findById(Long locationId) throws APIException;

    Location addLocation(Location location) throws APIException;

    Location updateLocation(Location location, Long locationId) throws APIException;

    List<Location> viewAllLocation();

    List<Location> viewLocationByActivity(Long activityId);

    void listLocationList(final ActivityListDto activityListDto);
}
