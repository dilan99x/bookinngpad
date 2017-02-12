package com.candela.bookingpad.custom.impl;

import com.candela.bookingpad.custom.LocationRepositoryCustom;
import com.candela.bookingpad.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepositoryCustom {

    private static final String FETCH_LOCATIONS_BY_ACTIVITIES = "select a.activity_id, a.activity_code, l.location_id," +
            " l.location_code\n" +
            " from activity as a\n" +
            "  inner join activity_location as al\n" +
            "   on a.activity_id = al.activity_id\n" +
            "   inner join location as l\n" +
            "    on l.location_id = al.location_id\n" +
            "    and al.activity_id in (1,2,3)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Location> listLocationsByActivities(List<Long> activityIdList) throws SQLException {
        return jdbcTemplate.query("select * from location", new Object[]{}, (resultSet, i) ->
                extractLocations(resultSet)
        );
    }

    private Location extractLocations(ResultSet resultSet) throws SQLException {
        resultSet.getMetaData().getColumnCount();

        Location location = new Location();
        location.setLocationId(resultSet.getLong("location_id"));
        location.setLocationCode(resultSet.getString("location_code"));
        location.setDistrict(resultSet.getString("district"));
        location.setProvince(resultSet.getString("province"));
        return location;
    }
}
