package com.candela.bookingpad.activityops.custom;

import com.candela.bookingpad.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long>, ActivityRepositoryCustom {

}
