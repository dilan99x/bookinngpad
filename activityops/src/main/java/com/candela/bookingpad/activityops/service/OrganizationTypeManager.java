package com.candela.bookingpad.activityops.service;


import com.candela.bookingpad.entity.OrganizationType;
import com.candela.bookingpad.exception.APIException;

public interface OrganizationTypeManager {
    OrganizationType findById(Long organizationTypeId) throws APIException;

    OrganizationType addOrganizationType(OrganizationType organizationType) throws APIException;

    OrganizationType findByOrganizationTypeName(String name);
}
