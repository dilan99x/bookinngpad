package com.candela.bookingpad.activityops.custom;

import com.candela.bookingpad.entity.Activity;

import java.util.List;

public interface ActivityRepositoryCustom {
    Activity findByCriterion(final Activity activity);

    List<Activity> findByCriteria(final Activity activity);
}
