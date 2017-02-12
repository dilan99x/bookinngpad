package com.candela.bookingpad.activityops.service.impl;

import com.candela.bookingpad.activityops.custom.OrganizationTypeRepository;
import com.candela.bookingpad.activityops.service.OrganizationTypeManager;
import com.candela.bookingpad.entity.OrganizationType;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.exception.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrganizationTypeManagerImpl implements OrganizationTypeManager {

    @Autowired
    private OrganizationTypeRepository organizationTypeRepository;

    @Override
    public OrganizationType findById(Long organizationTypeId) throws APIException {
        OrganizationType organizationType = organizationTypeRepository.findOne(organizationTypeId);
        if (organizationType == null) {
            throw new APIException(ErrorCodeEnum.ORGANIZATION_TYPE_NOT_FOUND);
        }
        return organizationType;
    }

    @Override
    public OrganizationType addOrganizationType(OrganizationType organizationType) throws APIException {
        OrganizationType organizationTypeFetched = findByOrganizationTypeName(organizationType.getOrganizationTypeCode());
        if (organizationTypeFetched == null) {
            throw new APIException(ErrorCodeEnum.ORGANIZATION_TYPE_BY_NAME_FOUND);
        }
        return organizationTypeRepository.save(organizationType);
    }

    @Override
    public OrganizationType findByOrganizationTypeName(String name) {
        return organizationTypeRepository.findByOrganizationTypeCode(name);
    }
}
