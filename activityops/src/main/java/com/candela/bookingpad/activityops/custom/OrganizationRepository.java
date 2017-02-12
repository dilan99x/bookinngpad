package com.candela.bookingpad.activityops.custom;

import com.candela.bookingpad.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query(value = "SELECT * FROM organization as org INNER JOIN activity_organization act_org ON act_org.organization_id=org.organization_id INNER JOIN activity act ON act.activity_id = act_org.activity_id WHERE activity.activity_id= :activityId", nativeQuery = true)
    List<Organization> findOrganizationByActivityId(@Param("activityId") Long activityId);

    Organization findByOrganizationName(String organizationName);
}
