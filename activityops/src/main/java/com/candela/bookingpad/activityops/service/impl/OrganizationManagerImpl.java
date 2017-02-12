package com.candela.bookingpad.activityops.service.impl;

import com.candela.bookingpad.activityops.custom.OrganizationRepository;
import com.candela.bookingpad.activityops.service.OrganizationManager;
import com.candela.bookingpad.activityops.service.OrganizationTypeManager;
import com.candela.bookingpad.entity.Organization;
import com.candela.bookingpad.entity.OrganizationType;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.exception.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationManagerImpl implements OrganizationManager {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationTypeManager organizationTypeManager;

    @Override
    public Organization findById(Long id) throws APIException {
        Organization organization = organizationRepository.findOne(id);
        if (organization == null) {
            throw new APIException(ErrorCodeEnum.ORGANIZATION_NOT_FOUND);
        }
        return organization;
    }

    @Override
    public Organization findByOrganizationName(String organizationName) throws APIException {
        return organizationRepository.findByOrganizationName(organizationName);
    }

    @Override
    public List<Organization> findByActivity(Long activityId) {
        return organizationRepository.findOrganizationByActivityId(activityId);
    }

    @Override
    public Organization addOrganization(Organization organization, Long organizationTypeId) throws APIException {
        Organization organizationFetched = findByOrganizationName(organization.getOrganizationName());
        if (organizationFetched != null) {
            throw new APIException(ErrorCodeEnum.ORGANIZATION_FOUND_BY_NAME);
        }
        OrganizationType organizationType = organizationTypeManager.findById(organizationTypeId);
        organization.setOrganizationTypeId(organizationType);
        return organizationRepository.save(organization);
    }

    @Override
    public Organization updateOrganization(final Organization organization) throws APIException {
        Organization organizationFetched = findById(organization.getOrganizationId());
        if (organizationFetched == null) {
            throw new APIException(ErrorCodeEnum.ORGANIZATION_NOT_FOUND);
        }
        return organizationRepository.save(organization);
    }
}
