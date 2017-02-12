package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "activity_organization")
@XmlRootElement
public class ActivityOrganization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_organization_id")
    private Long activityOrganizationId;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToMany(mappedBy = "activityOrganizationId")
    private List<Offer> offerList;
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    @ManyToOne
    private Activity activity;
    @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
    @ManyToOne
    private Organization organization;
    @OneToMany(mappedBy = "activityOrganizationId")
    private List<Payment> paymentList;


    public Long getActivityOrganizationId() {
        return activityOrganizationId;
    }

    public void setActivityOrganizationId(Long activityOrganizationId) {
        this.activityOrganizationId = activityOrganizationId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityOrganizationId != null ? activityOrganizationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityOrganization)) {
            return false;
        }
        ActivityOrganization other = (ActivityOrganization) object;
        if ((this.activityOrganizationId == null && other.activityOrganizationId != null) || (this.activityOrganizationId != null && !this.activityOrganizationId.equals(other.activityOrganizationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivityOrganization[ activityOrganizationId=" + activityOrganizationId + " ]";
    }

}
