package com.candela.bookingpad.controller;

import com.candela.bookingpad.dto.ActivityListDto;
import com.candela.bookingpad.dto.LocationDto;
import com.candela.bookingpad.entity.Location;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.mapper.LocationMapper;
import com.candela.bookingpad.service.LocationManager;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
    @Autowired
    private LocationManager locationManager;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public LocationDto addLocation(@RequestBody LocationDto locationDto) throws APIException {
        LOGGER.info("called addLocation()");
        return locationMapper.mapToDto(locationManager.addLocation(modelMapper.map(locationDto, Location.class)), new LocationDto());
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, value = "/{id}")
    public LocationDto updateLocation(@RequestBody LocationDto locationDto, @PathVariable(value = "id") Long locationId) throws APIException {
        LOGGER.info("called updateLocation()");
        return locationMapper.mapToDto(locationManager.updateLocation(modelMapper.map(locationDto, Location.class), locationId), new LocationDto());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<LocationDto> viewAllLocation() throws APIException {
        LOGGER.info("called viewAllLocation()");
        return locationMapper.mapToDto(locationManager.viewAllLocation(), new LinkedList<>());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, value = "/{id}")
    public List<LocationDto> viewLocationByActivity(@PathVariable(value = "id") Long activityId) throws APIException {
        LOGGER.info("called viewLocationByActivity()");
        return locationMapper.mapToDto(locationManager.viewLocationByActivity(activityId), new LinkedList<>());
    }

    /**
     * This endpoint is used to ritreive list of locations relevant to the multiple activities sent by user
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public List<LocationDto> viewLocationsByListOfActivities(@RequestBody final ActivityListDto activityListDto) {
        LOGGER.info("called viewLocationsByListOfActivities");
        locationManager.listLocationList(activityListDto);
        return null;
    }
}
