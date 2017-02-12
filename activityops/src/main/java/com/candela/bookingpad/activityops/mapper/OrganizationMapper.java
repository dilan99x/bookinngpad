package com.candela.bookingpad.activityops.mapper;

import com.candela.bookingpad.dto.OrganizationDto;
import com.candela.bookingpad.entity.ActivityOrganization;
import com.candela.bookingpad.entity.Organization;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.mapper.BaseMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrganizationMapper extends BaseMapper<Organization, OrganizationDto> {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrganizationMapper.class);

    @Override
    public OrganizationDto mapToDto(Organization organization, OrganizationDto organizationDto) throws APIException {
        validate(organization, organizationDto);
        organizationDto.setOrganizationId(organization.getOrganizationId());
        organizationDto.setDescription(organization.getDescription());
        organizationDto.setIsActive(organization.getIsActive());
        organizationDto.setOrganizationAddress(organization.getOrganizationAddress());
        organizationDto.setOrganizationName(organization.getOrganizationName());
        List<Long> organizationActivityIdList = new LinkedList<>();
        List<Long> activityIdList = new LinkedList<>();
        if (organization.getActivityOrganizationList() != null) {
            for (ActivityOrganization activityOrganization : organization.getActivityOrganizationList()) {
                organizationActivityIdList.add(activityOrganization.getActivityOrganizationId());
                activityIdList.add(activityOrganization.getActivity() != null ? activityOrganization.getActivity().getActivityId() : null);
            }
        }
        organizationDto.setActivityOrganizationList(organizationActivityIdList);
        organizationDto.setActivityList(activityIdList);
        LOGGER.info("Organization Mapper -> Mapper convertion has been done!");

        return organizationDto;
    }

    @Override
    public List<OrganizationDto> mapToDto(List<Organization> organizations, List<OrganizationDto> organizationDtos) throws APIException {
        validateList(organizations, organizationDtos);
        for (Organization organization : organizations) {
            organizationDtos.add(mapToDto(organization, new OrganizationDto()));
        }
        return organizationDtos;
    }
}
