package com.candela.bookingpad.activityops.service;

import com.candela.bookingpad.entity.Organization;
import com.candela.bookingpad.exception.APIException;

import java.util.List;

public interface OrganizationManager {

    Organization findById(final Long id) throws APIException;

    Organization findByOrganizationName(final String organizationName) throws APIException;

    List<Organization> findByActivity(final Long activityId);

    Organization addOrganization(final Organization organization, Long organizationTypeId) throws APIException;

    Organization updateOrganization(final Organization organization) throws APIException;
}
