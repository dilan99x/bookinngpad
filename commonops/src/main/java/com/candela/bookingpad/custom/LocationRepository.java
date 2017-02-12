package com.candela.bookingpad.custom;

import com.candela.bookingpad.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryCustom{

    Location findByLocationCode(String locationCode);

    @Query(value = "SELECT * FROM location AS loc INNER JOIN activity_location AS aloc ON aloc.location_id = loc.location_id INNER JOIN activity AS act\n" +
            "  ON act.activity_id = aloc.activity_id AND act.activity_id = :id", nativeQuery = true)
    List<Location> viewLocationByActivity(@Param("id") Long activityId);
}
