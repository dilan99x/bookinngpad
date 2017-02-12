package com.candela.bookingpad.activityops.mapper;

import com.candela.bookingpad.dto.ActivityOrganizationDto;
import com.candela.bookingpad.entity.ActivityOrganization;
import com.candela.bookingpad.entity.Offer;
import com.candela.bookingpad.entity.Payment;
import com.candela.bookingpad.exception.APIException;
import com.candela.bookingpad.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by thilanka on 2/20/16.
 */
@Component
public class ActivityOrganizationMapper extends BaseMapper<ActivityOrganization, ActivityOrganizationDto> {

    @Override
    public ActivityOrganizationDto mapToDto(ActivityOrganization activityOrganization, ActivityOrganizationDto activityOrganizationDto) throws APIException {

        validate(activityOrganization, activityOrganizationDto);
        activityOrganizationDto.setActivityOrganizationId(activityOrganization.getActivityOrganizationId());
        List<Integer> offers = activityOrganization.getOfferList() == null ? null : activityOrganization.getOfferList().stream().map(Offer::getOfferId).collect(Collectors.toList());
        activityOrganizationDto.setOfferList(offers);
        if(activityOrganization.getActivity() != null) {
            activityOrganizationDto.setActivity(activityOrganization.getActivity().getActivityId());
        }
        if(activityOrganization.getOrganization() != null) {
            activityOrganizationDto.setOrganization(activityOrganization.getOrganization().getOrganizationId());
        }
        activityOrganizationDto.setIsActive(activityOrganization.getIsActive());
        List<Integer> payments = activityOrganization.getPaymentList() == null ? null : activityOrganization.getPaymentList().stream().map(Payment::getPaymentId).collect(Collectors.toList());
        activityOrganizationDto.setPaymentList(payments);

        return activityOrganizationDto;
    }

    @Override
    public List<ActivityOrganizationDto> mapToDto(List<ActivityOrganization> activityOrganizations, List<ActivityOrganizationDto> activityOrganizationDtos) throws APIException {
        validateList(activityOrganizations, activityOrganizationDtos);
        for (ActivityOrganization activityOrganization : activityOrganizations) {
            activityOrganizationDtos.add(mapToDto(activityOrganization, new ActivityOrganizationDto()));
        }
        return activityOrganizationDtos;
    }
}
