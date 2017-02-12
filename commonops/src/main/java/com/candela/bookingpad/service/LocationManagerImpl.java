package com.candela.bookingpad.service;

import com.candela.bookingpad.custom.LocationRepository;
import com.candela.bookingpad.dto.ActivityListDto;
import com.candela.bookingpad.entity.Location;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.exception.ErrorCodeEnum;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationManagerImpl implements LocationManager {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LocationManagerImpl.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findByLocationCode(String locationCode) {
        return locationRepository.findByLocationCode(locationCode);
    }

    @Override
    public Location findById(Long locationId) throws APIException {
        Location location = locationRepository.findOne(locationId);
        if (location == null) {
            throw new APIException(ErrorCodeEnum.LOCATION_ID_NOT_AVAILABLE);
        }
        return location;
    }

    @Override
    public Location addLocation(Location location) throws APIException {
        if (findByLocationCode(location.getLocationCode()) != null) {
            throw new APIException(ErrorCodeEnum.LOCATION_ALREADY_AVAILABLE);
        }
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location, Long locationId) throws APIException {
        Location locationFetched = findById(locationId);
        location.setLocationId(locationFetched.getLocationId());
        return locationRepository.save(location);
    }

    @Override
    public List<Location> viewAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public List<Location> viewLocationByActivity(Long activityId) {
        return locationRepository.viewLocationByActivity(activityId);
    }

    @Override
    public void listLocationList(final ActivityListDto activityListDto) {


    }
}
