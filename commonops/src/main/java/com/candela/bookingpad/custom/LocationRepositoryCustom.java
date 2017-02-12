package com.candela.bookingpad.custom;

import com.candela.bookingpad.entity.Location;

import java.sql.SQLException;
import java.util.List;

public interface LocationRepositoryCustom {
    List<Location> listLocationsByActivities(List<Long> activityIdList) throws SQLException;
}
