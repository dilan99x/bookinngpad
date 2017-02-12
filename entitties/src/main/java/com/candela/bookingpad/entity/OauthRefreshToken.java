package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "oauth_refresh_token")
@XmlRootElement
public class OauthRefreshToken implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oauth_refresh_token_id")
    private Integer oauthRefreshTokenId;
    @Column(name = "token_id")
    private String tokenId;
    @Lob
    @Column(name = "token")
    private byte[] token;
    @Lob
    @Column(name = "authentication")
    private byte[] authentication;

    public Integer getOauthRefreshTokenId() {
        return oauthRefreshTokenId;
    }

    public void setOauthRefreshTokenId(Integer oauthRefreshTokenId) {
        this.oauthRefreshTokenId = oauthRefreshTokenId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oauthRefreshTokenId != null ? oauthRefreshTokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthRefreshToken)) {
            return false;
        }
        OauthRefreshToken other = (OauthRefreshToken) object;
        if ((this.oauthRefreshTokenId == null && other.oauthRefreshTokenId != null) || (this.oauthRefreshTokenId != null && !this.oauthRefreshTokenId.equals(other.oauthRefreshTokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OauthRefreshToken[ oauthRefreshTokenId=" + oauthRefreshTokenId + " ]";
    }
}
