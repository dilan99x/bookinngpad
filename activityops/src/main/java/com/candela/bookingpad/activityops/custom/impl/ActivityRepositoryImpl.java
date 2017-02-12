package com.candela.bookingpad.activityops.custom.impl;

import com.candela.bookingpad.activityops.custom.ActivityRepositoryCustom;
import com.candela.bookingpad.entity.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityRepositoryImpl implements ActivityRepositoryCustom {
    @Override
    public Activity findByCriterion(Activity activity) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<Activity> findByCriteria(Activity activity) {
        throw new RuntimeException("Not yet implemented");
    }
}
