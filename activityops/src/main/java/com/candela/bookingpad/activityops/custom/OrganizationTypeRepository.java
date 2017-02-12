package com.candela.bookingpad.activityops.custom;

import com.candela.bookingpad.entity.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Long> {

    OrganizationType findByOrganizationTypeCode(String organizationTypeCode);
}
