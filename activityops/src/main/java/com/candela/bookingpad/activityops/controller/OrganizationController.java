package com.candela.bookingpad.activityops.controller;

import com.candela.bookingpad.activityops.mapper.OrganizationMapper;
import com.candela.bookingpad.activityops.service.OrganizationManager;
import com.candela.bookingpad.dto.OrganizationDto;
import com.candela.bookingpad.entity.Organization;
import com.candela.bookingpad.exception.APIException;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationManager organizationManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_JSON})
    public OrganizationDto addOrganization(@RequestBody OrganizationDto organizationDto) throws APIException {
        LOGGER.info("####----OrganizationController----####");
        LOGGER.info("addOrganization method execution done!");
        return organizationMapper.mapToDto(organizationManager.addOrganization(modelMapper.map(organizationDto, Organization.class), organizationDto.getOrganizationTypeId()), new OrganizationDto());
    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON}, consumes = {MediaType.APPLICATION_JSON})
    public OrganizationDto updateOrganization(@RequestBody OrganizationDto organizationDto, @PathVariable("organizationId") Long organizationId) throws APIException {
        LOGGER.info("####----OrganizationController----####");
        LOGGER.info("update Organization method execution");
        return organizationMapper.mapToDto(organizationManager.updateOrganization(modelMapper.map(organizationDto, Organization.class)), new OrganizationDto());
    }
}
