package com.candela.bookingpad.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "oauth_access_token")
@XmlRootElement
public class OauthAccessToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oauth_access_token_id")
    private Integer oauthAccessTokenId;
    @Column(name = "token_id")
    private String tokenId;
    @Lob
    @Column(name = "token")
    private byte[] token;
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "client_id")
    private String clientId;
    @Lob
    @Column(name = "authentication")
    private byte[] authentication;
    @Column(name = "refresh_token")
    private String refreshToken;


    public Integer getOauthAccessTokenId() {
        return oauthAccessTokenId;
    }

    public void setOauthAccessTokenId(Integer oauthAccessTokenId) {
        this.oauthAccessTokenId = oauthAccessTokenId;
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

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oauthAccessTokenId != null ? oauthAccessTokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthAccessToken)) {
            return false;
        }
        OauthAccessToken other = (OauthAccessToken) object;
        if ((this.oauthAccessTokenId == null && other.oauthAccessTokenId != null) || (this.oauthAccessTokenId != null && !this.oauthAccessTokenId.equals(other.oauthAccessTokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OauthAccessToken[ oauthAccessTokenId=" + oauthAccessTokenId + " ]";
    }
}
