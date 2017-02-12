package com.candela.bookingpad.mapper;

import com.candela.bookingpad.dto.LocationDto;
import com.candela.bookingpad.entity.Activity;
import com.candela.bookingpad.entity.Location;
import com.candela.bookingpad.exception.APIException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class LocationMapper extends BaseMapper<Location, LocationDto> {

    @Override
    public LocationDto mapToDto(Location location, LocationDto locationDto) throws APIException {
        validate(location, locationDto);
        locationDto.setLocationId(location.getLocationId());
        locationDto.setLocationCode(location.getLocationCode());
        locationDto.setDistrict(location.getDistrict());
        locationDto.setProvince(location.getProvince());
        if (location.getActivityList() != null) {
            List<Long> activityIds = new LinkedList<>();
            for (Activity activity : location.getActivityList()) {
                activityIds.add(activity.getActivityId());
            }
            locationDto.setActivityList(activityIds);
        }

        return locationDto;
    }

    @Override
    public List<LocationDto> mapToDto(List<Location> locations, List<LocationDto> locationDtos) throws APIException {
        validateList(locations, locationDtos);
        for (Location location : locations) {
            locationDtos.add(mapToDto(location, new LocationDto()));
        }
        return locationDtos;
    }
}
